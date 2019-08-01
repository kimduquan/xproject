using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Caching.Memory;
using XSystem;
using XSystem.XReflection;
using XWebApplication.Models;
using XWebApplication.Models.XSystem;
using XWebApplication.Models.XSystem.XReflection;

namespace XWebApplication.Pages
{
    [Authorize( Policy = "Assembly" )]
    public class XAssemblyModel : PageModel
    {
        private XAssembly xassembly = null;
        private IMemoryCache cache = null;
        private _XThisCache xthis = null;
        private string title = null;

        public XAssemblyModel(IMemoryCache memory, X xx)
        {
            cache = memory;
            X = xx;
        }

        public _XThisCache XThis
        {
            get
            {
                if(xthis == null)
                {
                    xthis = _XThisModel.XFromCache(cache, HttpContext.Session);
                }
                return xthis;
            }
        }

        public X X { get; }

        public XAssembly XAssembly
        {
            get
            {
                if (xassembly == null)
                {
                    xassembly = _XAssemblyModel.XFromRoute(RouteData, X);
                }
                return xassembly;
            }
        }

        public string XTitle
        {
            get
            {
                if(title == null)
                {
                    title = _XStringModel.XToString(XAssembly, XThis.XString);
                }
                return title;
            }
        }

        public void OnGet()
        {
            object x = XAssembly;
        }
    }
}