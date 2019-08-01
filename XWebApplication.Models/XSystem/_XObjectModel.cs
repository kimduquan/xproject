using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem
{
    public class _XObjectModel : _XModel
    {
        public XObject XObject { get; }
        public XMethodInfo[] XMethods { get; set; }
        public Dictionary<string, List<XFieldInfo>> XFields { get; set; }
        public List<XType> XFieldTypes { get; set; }
        public Dictionary<string, List<XPropertyInfo>> XProperties { get; set; }
        public List<XType> XPropertyTypes { get; set; }
        public XType XType { get; set; }

        public _XObjectModel(XObject xobj, _XThisCache xthis) : base(xthis)
        {
            XObject = xobj;
        }

        public static string XToHref(XObject xobject)
        {
            string href = _XTypeModel.XToHref(xobject.XGetType());
            href += ("/" + xobject.XGetHashCode());
            return href;
        }

        public static string XToKey(XObject xobject)
        {
            return xobject.XGetType().XFullName + "@" + xobject.XGetHashCode();
        }

        public static XObject XFromCache(_XThisCache xthis, string key)
        {
            XObject xobject = null;
            if (xthis.XObjects.ContainsKey(key))
            {
                xthis.XObjects.TryGetValue(key, out xobject);
            }
            return xobject;
        }

        public static void XToCache(_XThisCache cache, XObject xobject)
        {
            string key = XToKey(xobject);
            cache.XObjects.Add(key, xobject);
        }

        public static XObject XFromCache(_XThisCache xthis, XType xtype, int hashCode)
        {
            XObject xobject = null;
            string key = xtype.XFullName + "@" + hashCode;
            if (xthis.XObjects.ContainsKey(key))
            {
                xthis.XObjects.TryGetValue(key, out xobject);
            }
            return xobject;
        }
    }
}
