using XSystem;
using XWebApplication.Util;

namespace XWebApplication.Models.XSystem
{
    public class _XObjectModel : _XModel
    {
        public _XObjectModel(_XThisCache xthis) : base(xthis)
        {

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
