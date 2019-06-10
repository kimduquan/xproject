using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Caching.Memory;
using System.Collections.Generic;
using XSystem;

namespace XWebApplication.Util
{
    public class _XObjectCache
    {
        string Key { get; }
        IMemoryCache Cache { get; }
        public XObject XThis { get; }

        _XObjectCache(string key, IMemoryCache cache)
        {
            Cache = cache;
            Key = key;
        }

        static string XToKey(XObject xobject)
        {
            return xobject.XGetType().XFullName + "@" + xobject.XGetHashCode();
        }

        public static _XObjectCache XFromSession(ISession session, IMemoryCache cache)
        {
            string key = session.GetString("this");
            return new _XObjectCache(key, cache);
        }

        public Dictionary<string, Dictionary<int, XObject>> XObjects { get; }
        public List<XType> XTypes { get; }
    }
}
