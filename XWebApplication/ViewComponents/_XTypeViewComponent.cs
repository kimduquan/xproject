using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using XSystem;
using XWebApplication.Models.XSystem;
using XWebApplication.Util;

namespace XWebApplication.ViewComponents
{
    public class _XTypeViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(_XThisCache xthis, XType xtype)
        {
            return View(new _XTypeModel(xtype, xthis));
        }
    }
}
