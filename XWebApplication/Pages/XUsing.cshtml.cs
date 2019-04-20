using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.Collections.Generic;
using System.Security.Claims;
using XSystem;
using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using XSystem.XReflection;
using Microsoft.Extensions.Caching.Memory;

namespace XWebApplication.Pages
{
    [AllowAnonymous]
    public class XUsingModel : PageModel
    {
        private XType xtype = null;
        private XType xentryType = null;
        private XMethodInfo xmethodInfo = null;
        private XMethodInfo[] xmethodInfos = null;
        private XObject[] xobjects = null;
        private IMemoryCache cache = null;

        public XType XType
        {
            get
            {
                if (xtype == null)
                {
                    string url = "";
                    XUtil.XFromReturnUrl(Request.Query, out xtype, out url);
                }
                return xtype;
            }
        }

        public XType XEntryType
        {
            get
            {
                if (xentryType == null)
                {
                    XUtil.XGetEntryType(XType.XAssembly, out xentryType);
                }
                return xentryType;
            }
        }

        [BindProperty(SupportsGet = true)]
        public string Using { get; set; }

        [BindProperty(SupportsGet = true)]
        public string ReturnUrl { get; set; }

        public XMethodInfo[] XMethodInfos
        {
            get
            {
                if(xmethodInfos == null)
                {
                    XUtil.XGetEntryMethods(XEntryType, out xmethodInfos);
                }
                return xmethodInfos;
            }
        }

        public XMethodInfo XMethodInfo
        {
            get
            {
                if(xmethodInfo == null)
                {
                    if(XMethodInfos != null)
                    {
                        if (XMethodInfos.Length == 1)
                        {
                            xmethodInfo = XMethodInfos[0];
                        }
                        else if (Using != null && Using != "")
                        {
                            foreach(XMethodInfo m in XMethodInfos)
                            {
                                if(m.XName == Using)
                                {
                                    xmethodInfo = m;
                                    break;
                                }
                            }
                        }
                    }
                }
                return xmethodInfo;
            }
        }

        public XObject[] XObjects
        {
            get
            {
                if(xobjects == null)
                {
                    List<XObject> objects = null;
                    XUtil.XFromForm(out objects, XMethodInfo.XGetParameters(), Request.Form);
                    xobjects = objects.ToArray();
                }
                return xobjects;
            }
        }

        public async Task<IActionResult> OnPostAsync()
        {
            if(ModelState.IsValid)
            {
                if(XMethodInfo != null)
                {
                    XObject xobject = XMethodInfo.XInvoke(XUtil.X.XNULL, XObjects);
                    if(xobject != XUtil.X.XNULL)
                    {
                        XUtil.XToSession(xobject, HttpContext.Session);
                        XUtil.XToCache(xobject, cache, HttpContext.Session);
                        List<Claim> claims = new List<Claim>()
                        {
                            new Claim(ClaimTypes.Name, xobject.XToString()),
                            new Claim("Type", xobject.XGetType().XFullName),
                            new Claim("hashCode", "" + xobject.XGetHashCode())
                        };
                        List<ClaimsIdentity> identities = new List<ClaimsIdentity>()
                        {
                            new ClaimsIdentity
                            (
                                claims,
                                CookieAuthenticationDefaults.AuthenticationScheme
                            )
                        };
                        ClaimsPrincipal principal = new ClaimsPrincipal(identities);
                        return SignIn(principal, CookieAuthenticationDefaults.AuthenticationScheme);
                    }
                }
            }
            return Page();
        }

        public async Task<IActionResult> OnPostUsingAsync()
        {
            return Page();
        }

        public XUsingModel(IMemoryCache memory)
        {
            cache = memory;
        }
    }
}