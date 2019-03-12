using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Caching.Memory;
using XSystem;
using XSystem.XInternal;

namespace XWebApplication.Pages
{
    public class XObjectModel : PageModel
    {
        private XObject xobject = null;
        private IMemoryCache cache = null;

        public XObject XObject
        {
            get
            {
                if(xobject == null)
                {
                    Util.XFromRoute(out xobject, RouteData, cache);
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