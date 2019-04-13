using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.RazorPages;
using XSystem;

namespace XWebApplication.Pages
{
    [Authorize]
    public class XRefModel : PageModel
    {
        public void OnGet()
        {
        }

        public XType xtype { get; set; }
    }
}