using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Caching.Memory;
using System.Collections.Generic;
using XSystem;
using XWebApplication.Util;

namespace XWebApplication.Models
{
    public class _XThisModel
    {
        public _XObjectCache XCache { get; }

        public _XThisModel(IMemoryCache cache, ISession session)
        {
            XCache = _XObjectCache.XFromSession(session, cache);
        }

        public static void XToSession(XObject xthis, ISession session)
        {
            session.SetString("this", xthis.XGetType().XFullName + "@" + xthis.XGetHashCode());
        }

        public static void XToCache(XObject obj, IMemoryCache cache, ISession session)
        {
            Dictionary<string, XObject> xobjects = null;
            XGetCache(cache, session, out xobjects);
            string key = obj.XGetType().XFullName + "@" + obj.XGetHashCode();
            xobjects.TryAdd(key, obj);
        }

        protected static void XGetCache(IMemoryCache cache, ISession session, out Dictionary<string, XObject> xobjects)
        {
            string xthis = session.GetString("this");
            if (cache.TryGetValue(xthis, out xobjects) == false)
            {
                xobjects = new Dictionary<string, XObject>();
                using (ICacheEntry entry = cache.CreateEntry(xthis))
                {
                    entry.SetValue(xobjects);
                }
            }
        }
    }
}
