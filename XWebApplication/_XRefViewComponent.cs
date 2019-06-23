using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;

namespace XWebApplication
{
    public class _XRefViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync()
        {
            return View();
        }
    }
}
