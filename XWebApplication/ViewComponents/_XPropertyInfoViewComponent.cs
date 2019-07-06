using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using XSystem;
using XSystem.XReflection;
using XWebApplication.Models.XSystem.XReflection;

namespace XWebApplication.ViewComponents
{
    public class _XPropertyInfoViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(XType xtype, XObject xobject, XPropertyInfo property, char key, int index)
        {
            return View(new _XPropertyInfoModel(null, property, key, index));
        }
    }
}
