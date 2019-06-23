using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using XSystem.XReflection;
using XWebApplication.Models.XSystem.XReflection;

namespace XWebApplication.ViewComponents
{
    public class _XParameterInfoViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(XParameterInfo xparameter, char accessKey, int tabIndex)
        {
            _XParameterInfoModel xmodel = new _XParameterInfoModel(xparameter);
            xmodel.AccessKey = accessKey;
            xmodel.TabIndex = tabIndex;
            return View(xmodel);
        }
    }
}
