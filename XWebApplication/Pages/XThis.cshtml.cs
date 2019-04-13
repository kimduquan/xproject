using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Caching.Memory;
using XSystem;

namespace XWebApplication.Pages
{
    [Authorize]
    public class XThisModel : PageModel
    {
        private IMemoryCache cache = null;
        private XObject xthis = null;

        public XObject XThis
        {
            get
            {
                if(xthis == null)
                {
                    XUtil.XFromCache(out xthis, cache, HttpContext.Session);
                }
                return xthis;
            }
        }

        public XThisModel(IMemoryCache memory)
        {
            cache = memory;
        }
    }
}