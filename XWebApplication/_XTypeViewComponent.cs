using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using XSystem;
using XWebApplication.Models;
using XWebApplication.Models.XSystem;

namespace XWebApplication
{
    public class _XTypeViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(_XThisModel xthis, XType xtype)
        {
            return View(new _XTypeModel(xtype, xthis));
        }
    }
}
