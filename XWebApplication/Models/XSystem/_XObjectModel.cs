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

        public static string XToString(XObject xobject)
        {
            string str = xobject.XToString();
            return str;
        }
    }
}
