using System.Collections.Generic;
using XSystem;

namespace XWebApplication.Util
{
    public class _XThisCache
    {
        public XObject XThis { get; }
        public Dictionary<string, XObject> XObjects { get; }

        public _XThisCache(XObject xthis)
        {
            XThis = xthis;
            XObjects = new Dictionary<string, XObject>();
            XObjects.Add(XToKey(xthis), xthis);
        }

        public static string XToKey(XObject xobject)
        {
            return xobject.XGetType().XFullName + "@" + xobject.XGetHashCode();
        }

        public XObject XObject(XType xtype, int hashCode)
        {
            XObject xobject = null;
            string key = xtype.XFullName + "@" + hashCode;
            if(XObjects.ContainsKey(key))
            {
                XObjects.TryGetValue(key, out xobject);
            }
            return xobject;
        }

        public XObject XObject(string key)
        {
            XObject xobject = null;
            if (XObjects.ContainsKey(key))
            {
                XObjects.TryGetValue(key, out xobject);
            }
            return xobject;
        }

        public static void XToCache(_XThisCache cache, XObject xobject)
        {
            string key = XToKey(xobject);
            cache.XObjects.Add(key, xobject);
        }
    }
}
