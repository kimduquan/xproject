using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using XSystem.XReflection;
using XWebApplication.Models.XSystem;
using XWebApplication.Models.XSystem.XReflection;

namespace XWebApplication
{
    public class _XFieldInfoViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(_XTypeModel type, XFieldInfo field, char key, int index)
        {
            return View(new _XFieldInfoModel(type, field, key, index));
        }
    }
}
