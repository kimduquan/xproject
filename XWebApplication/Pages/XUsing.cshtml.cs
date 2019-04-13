using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.Collections.Generic;
using System.Security.Claims;
using XSystem;
using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;

namespace XWebApplication.Pages
{
    [AllowAnonymous]
    public class XUsingModel : PageModel
    {
        private XType xtype = null;

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

        public async Task<IActionResult> OnPostAsync(string returnUrl = null)
        {
            if(ModelState.IsValid)
            {
                List<Claim> claims = new List<Claim>()
                {
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
            return Page();
        }
    }
}