using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using XSystem.XReflection;
using XWebApplication.Models.XSystem;
using XWebApplication.Models.XSystem.XReflection;

namespace XWebApplication
{
    public class _XPropertyInfoViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(_XTypeModel type, XPropertyInfo property, char key, int index)
        {
            return View(new _XPropertyInfoModel(type, property, key, index));
        }
    }
}
