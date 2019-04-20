using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Caching.Memory;
using XSystem;

namespace XWebApplication.Pages
{
    [Authorize( Policy = "object" )]
    public class XObjectModel : PageModel
    {
        private XObject xobject = null;
        private IMemoryCache cache = null;
        private XObject xthis = null;

        public XObject XThis
        {
            get
            {
                if (xthis == null)
                {
                    XUtil.XFromCache(out xthis, cache, HttpContext.Session);
                }
                return xthis;
            }
        }

        public XObject XObject
        {
            get
            {
                if(xobject == null)
                {
                    XType xtype = null;
                    XUtil.XFromRoute(out xtype, RouteData);
                    object hashCode = null;
                    RouteData.Values.TryGetValue("hashCode", out hashCode);
                    XUtil.XFromCache(out xobject, cache, HttpContext.Session, xtype.XFullName, int.Parse((string)hashCode));
                }
                return xobject;
            }
        }

        public XObjectModel(IMemoryCache c)
        {
            cache = c;
        }

        public void OnGet()
        {
        }
    }
}