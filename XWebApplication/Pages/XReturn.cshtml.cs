using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Caching.Memory;
using System.Threading.Tasks;
using XWebApplication.Models;
using XWebApplication.Models.XSystem;

namespace XWebApplication.Pages
{
    [Authorize]
    public class XReturnModel : PageModel
    {
        private IMemoryCache cache = null;
        public XReturnModel(IMemoryCache c)
        {
            cache = c;
        }

        public async Task<IActionResult> OnPostAsync()
        {
            if (ModelState.IsValid)
            {
                _XStringModel.XReturn(cache, HttpContext.Session);
                _XThisModel.XReturn(cache, HttpContext.Session);
                return SignOut(CookieAuthenticationDefaults.AuthenticationScheme);
            }   
            return Page();
        }
    }
}