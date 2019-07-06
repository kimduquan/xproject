using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using XSystem;
using XSystem.XReflection;
using XWebApplication.Models.XSystem.XReflection;

namespace XWebApplication.ViewComponents
{
    public class _XFieldInfoViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(XType xtype, XObject xobject, XFieldInfo field, char key, int index)
        {
            if(xtype == null)
            {
                xtype = xobject.XGetType();
            }
            return View(new _XFieldInfoModel(null, field, key, index));
        }
    }
}
