using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Threading.Tasks;
using XSystem.XReflection;
using XWebApplication.Models.XSystem.XReflection;

namespace XWebApplication.ViewComponents
{
    public class _XConstructorInfoViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(XConstructorInfo xconstructor)
        {
            _XConstructorInfoModel xmodel = new _XConstructorInfoModel();
            xmodel.XParameters = xconstructor.XGetParameters();
            Dictionary<string, char> accessKeyMap = null;
            List<char> accessKeys = null;
            _XMethodInfoModel.XToAccessKeyMap(xmodel.XParameters, out accessKeyMap, out accessKeys);
            xmodel.XAccessKeys = accessKeys;
            return View(xmodel);
        }
    }
}
