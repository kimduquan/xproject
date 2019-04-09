using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace XWebApplication.Pages
{
    [AllowAnonymous]
    public class XReturnModel : PageModel
    {
        public void OnGet()
        {

        }
    }
}