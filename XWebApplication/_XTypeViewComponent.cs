using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using XWebApplication.Models.XSystem;

namespace XWebApplication
{
    public class _XTypeViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(_XTypeModel xmodel)
        {
            return View(xmodel);
        }
    }
}
