using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.Threading.Tasks;
using XSystem;

namespace XWebApplication.Pages
{
    [Authorize]
    public class XThisModel : PageModel
    {
        public void OnGet()
        {

        }

        public async Task<IActionResult> OnPostAsync()
        {
            return SignOut(CookieAuthenticationDefaults.AuthenticationScheme);
        }
    }
}