using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using XSystem.XReflection;
using XWebApplication.Models.XSystem.XReflection;

namespace XWebApplication
{
    public class _XParameterInfoViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(XParameterInfo xparameter, char accessKey, int tabIndex)
        {
            _XParameterInfoModel xmodel = new _XParameterInfoModel();
            return View(xmodel);
        }
    }
}
