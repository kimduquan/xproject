using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Caching.Memory;
using XSystem;
using XWebApplication.Models;
using XWebApplication.Models.XSystem;
using XWebApplication.Util;

namespace XWebApplication.Pages
{
    [Authorize( Policy = "object" )]
    public class XObjectModel : PageModel
    {
        private XObject xobject = null;
        private IMemoryCache cache = null;
        private X x = null;
        private _XThisCache xthis = null;
        private string title = null;
        private XType xtype = null;

        public _XThisCache XThis
        {
            get
            {
                if (xthis == null)
                {
                    xthis = _XThisModel.XFromCache(cache, HttpContext.Session);
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
                    xobject = _XThisModel.XFromRoute(RouteData, XThis, x);
                }
                return xobject;
            }
        }

        public string Title
        {
            get
            {
                if(title == null)
                {
                    title = _XObjectModel.XToString(XObject);
                }
                return title;
            }
        }

        public XType XType
        {
            get
            {
                if(xtype == null)
                {
                    xtype = XObject.XGetType();
                }
                return xtype;
            }
        }

        public XObjectModel(IMemoryCache c, X xx)
        {
            cache = c;
            x = xx;
        }
    }
}