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
using XWebApplication.Models.XSystem.XReflection;
using XWebApplication.Models.XSystem;
using XWebApplication.Models;
using XSystem.XComponentModel;
using System;
using Microsoft.Extensions.Localization;

namespace XWebApplication.Pages
{
    [AllowAnonymous]
    public class XUsingModel : PageModel
    {
        private XType xusingType = null;
        private XType xentryType = null;
        private XMethodInfo xentryMethod = null;
        private XMethodInfo[] xentryMethods = null;
        private IMemoryCache cache = null;
        private string title = null;
        private XTypeConverter xtypeConverter = null;
        private X x = null;
        private IStringLocalizerFactory factory = null;
        private IStringLocalizer xstring = null;

        protected XType XUsingType
        {
            get
            {
                if (xusingType == null)
                {
                    string url = "";
                    xusingType = _XTypeModel.XFromReturnUrl(x, Request.Query, out url);
                }
                return xusingType;
            }
        }

        public XType XEntryType
        {
            get
            {
                if (xentryType == null)
                {
                    XAssembly xassembly = null;
                    if (XUsingType != null)
                    {
                        xassembly = XUsingType.XAssembly;
                    }
                    else
                    {
                        xassembly = _XAssemblyModel.XFromReturnUrl(Request.Query, x);
                    }
                    if(xassembly != null)
                    {
                        xentryType = _XAssemblyModel.XGetEntryType(xassembly);
                    }
                }
                return xentryType;
            }
        }

        [BindProperty(SupportsGet = true)]
        public string Using { get; set; }

        [BindProperty(SupportsGet = true)]
        public string ReturnUrl { get; set; }

        public XMethodInfo[] XEntryMethods
        {
            get
            {
                if(xentryMethods == null)
                {
                    xentryMethods = _XTypeModel.XGetEntryMethods(XEntryType);
                }
                return xentryMethods;
            }
        }

        public XMethodInfo XEntryMethod
        {
            get
            {
                if(xentryMethod == null)
                {
                    if(XEntryMethods != null)
                    {
                        if (XEntryMethods.Length == 1)
                        {
                            xentryMethod = XEntryMethods[0];
                        }
                        else if (Using != null && Using != "")
                        {
                            foreach(XMethodInfo m in XEntryMethods)
                            {
                                if(m.XName == Using)
                                {
                                    xentryMethod = m;
                                    break;
                                }
                            }
                        }
                    }
                }
                return xentryMethod;
            }
        }

        public string XTitle
        {
            get
            {
                if(title == null)
                {
                    if (XEntryType != null)
                    {
                        string name = "";
                        string assemblyName = "";
                        if (XEntryMethod != null)
                        {
                            name = _XStringModel.XToString(XEntryMethod, XString);
                            assemblyName = _XStringModel.XToString(XEntryType.XAssembly, XString);
                        }
                        else if (XUsingType != null)
                        {
                            name = _XStringModel.XToString(XUsingType, XString);
                            assemblyName = _XStringModel.XToString(XUsingType.XAssembly, XString);
                        }
                        title = string.Format("{0} - {1}", assemblyName, name);
                    }
                }
                return title;
            }
        }

        public XException XException { get; set; }

        public IStringLocalizer XString
        {
            get
            {
                if(xstring == null)
                {
                    xstring = _XStringModel.XFromSession(cache, HttpContext.Session);
                }
                if(xstring == null)
                {
                    xstring = _XStringModel.XToCache(XEntryType.XAssembly, cache, HttpContext.Session, factory);
                }
                return xstring;
            }
        }

        public async Task<IActionResult> OnPostAsync()
        {
            if(ModelState.IsValid)
            {
                if(XEntryMethod != null)
                {
                    XObject[] xparameters = _XMethodInfoModel.XFromForm(x, XEntryMethod.XGetParameters(), xtypeConverter, Request.Form, null);
                    try
                    {
                        XObject xobject = XEntryMethod.XInvoke(x.XNULL, xparameters);
                        if (xobject != x.XNULL)
                        {
                            _XThisModel.XToSession(xobject, HttpContext.Session);
                            _XThisModel.XToCache(xobject, cache, HttpContext.Session, XString);
                            List<Claim> claims = _XThisModel.XToClaims(xobject);
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
                    catch(Exception ex)
                    {
                        XException = x.XCatch(ex);
                    }
                }
            }
            return Page();
        }

        public async Task<IActionResult> OnPostUsingAsync()
        {
            return Page();
        }

        public XUsingModel(IMemoryCache memory, XTypeConverter converter, X xx, IStringLocalizerFactory f)
        {
            cache = memory;
            xtypeConverter = converter;
            x = xx;
            factory = f;
        }
    }
}