using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using XSystem.XReflection;

namespace XWebApplication
{
    public class _XFieldInfoViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(XFieldInfo xfieldInfo)
        {
            return View(xfieldInfo);
        }
    }
}
