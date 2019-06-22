using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Threading.Tasks;
using XSystem.XReflection;
using XWebApplication.Models.XSystem.XReflection;

namespace XWebApplication
{
    public class _XMethodInfoViewComponent : ViewComponent
    {

        public async Task<IViewComponentResult> InvokeAsync(XMethodInfo xmethod)
        {
            _XMethodInfoModel xmodel = new _XMethodInfoModel();
            xmodel.XParameters = xmethod.XGetParameters();
            Dictionary<string, char> accessKeyMap = null;
            List<char> accessKeys = null;
            _XMethodInfoModel.XToAccessKeyMap(xmodel.XParameters, out accessKeyMap, out accessKeys);
            xmodel.XAccessKeys = accessKeys;
            return View(xmodel);
        }
    }
}
