using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Primitives;
using System.Collections.Generic;
using System.Security.Claims;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Pages
{
    [AllowAnonymous]
    public class XUsingModel : PageModel
    {
        private XType xtype = null;
        private string returnUrl = null;

        public XType XType
        {
            get
            {
                if (xtype == null)
                {
                    Util.XFromReturnUrl(Request.Query, out xtype, out returnUrl);
                }
                return xtype;
            }
        }

        public string ReturnUrl
        {
            get
            {
                return returnUrl;
            }
        }

        public void OnPost()
        {
            List<Claim> claims = new List<Claim>()
            {
                new Claim(ClaimTypes.Name, "abc"),
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
            SignIn(principal, CookieAuthenticationDefaults.AuthenticationScheme).ExecuteResult(PageContext);
            StringValues url;
            if(Request.Form.TryGetValue("ReturnUrl", out url))
            {
                //Redirect(url.ToString());
            }
        }
    }
}