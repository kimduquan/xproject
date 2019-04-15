using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.Threading.Tasks;

namespace XWebApplication.Pages
{
    [Authorize]
    public class XReturnModel : PageModel
    {
        public async Task<IActionResult> OnPostAsync()
        {
            if (ModelState.IsValid)
            {
                HttpContext.Session.Remove("this");
                return SignOut(CookieAuthenticationDefaults.AuthenticationScheme);
            }   
            return Page();
        }
    }
}