using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Caching.Memory;
using System.Security.Claims;
using XSystem;

namespace XWebApplication.Models
{
    public class _XThisModel
    {
        protected _XThisModel()
        {

        }

        public static _XThisModel XFromCache(ClaimsPrincipal user, IMemoryCache cache, ISession session)
        {
            return null;
        }

        public static void XToCache(XObject xthis, IMemoryCache cache, ISession session)
        {

        }
    }
}
