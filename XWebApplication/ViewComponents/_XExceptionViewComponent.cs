using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using XSystem;
using XWebApplication.Models.XSystem;

namespace XWebApplication.ViewComponents
{
    public class _XExceptionViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(XException xexception)
        {
            _XExceptionModel xmodel = new _XExceptionModel(xexception);
            xmodel.XMessage = xexception.XInnerException.XMessage;
            return View(xmodel);
        }
    }
}
