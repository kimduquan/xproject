using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Caching.Memory;
using XSystem;
using XWebApplication.Util;

namespace XWebApplication.Models
{
    public class _XThisModel
    {
        public _XThisCache XCache { get; }

        public _XThisModel(_XThisCache xcache)
        {
            XCache = xcache;
        }

        public static void XToSession(XObject xthis, ISession session)
        {
            session.SetString("this", _XThisCache.XToKey(xthis));
        }

        public static void XToCache(XObject xthis, IMemoryCache cache, ISession session)
        {
            string key = session.GetString("this");
            _XThisCache xthisCache = new _XThisCache(xthis);
            using (ICacheEntry entry = cache.CreateEntry(key))
            {
                entry.SetValue(xthisCache);
            }
        }

        public static void XFromCache(IMemoryCache cache, ISession session, out _XThisCache xthis)
        {
            string key = session.GetString("this");
            cache.TryGetValue(key, out xthis);
        }
    }
}
