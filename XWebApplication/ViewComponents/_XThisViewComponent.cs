using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Threading.Tasks;
using XSystem;
using XWebApplication.Models;

namespace XWebApplication.ViewComponents
{
    public class _XThisViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(_XThisCache xthis)
        {
            _XThisModel xmodel = new _XThisModel(xthis);
            xmodel.XObjects = new Dictionary<string, List<XObject>>();
            foreach (XObject xobject in xmodel.XObjects.Values)
            {
                string key = xobject.XGetType().XFullName;
                if (xmodel.XObjects.ContainsKey(key))
                {
                    List<XObject> list = xmodel.XObjects[key];
                    list.Add(xobject);
                }
                else
                {
                    List<XObject> list = xmodel.XObjects[key];
                    list.Add(xobject);
                    xmodel.XObjects.Add(key, list);
                }
            }
            return View(xmodel);
        }
    }
}
