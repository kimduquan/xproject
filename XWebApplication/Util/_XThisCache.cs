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
    }
}
