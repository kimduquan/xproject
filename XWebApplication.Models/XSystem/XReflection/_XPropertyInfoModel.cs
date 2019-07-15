using _XSystem;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem.XReflection
{
    public class _XPropertyInfoModel
    {
        public _XPropertyInfoModel(_XTypeModel t, XPropertyInfo prop, char key, int index)
        {
            XAccessKey = key;
            XTabIndex = index;
        }

        public char XAccessKey { get; }
        public int XTabIndex { get; }

        public static string XToString(XPropertyInfo xprop)
        {
            return _XModel.XToString(xprop.XName);
        }

        public static bool XIsImplicit(XPropertyInfo xprop, X x)
        {
            return xprop.XGetCustomAttributes(x.XTypeOf(typeof(_XImplicit)), false).Length > 0;
        }
    }
}
