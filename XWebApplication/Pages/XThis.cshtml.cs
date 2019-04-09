using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace XWebApplication.Pages
{
    [Authorize]
    public class XThisModel : PageModel
    {
        public void OnGet()
        {

        }
    }
}