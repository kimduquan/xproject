using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;

namespace XWebApplication.ViewComponents
{
    public class _XRefViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync()
        {
            return View();
        }
    }
}
