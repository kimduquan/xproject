using _XSystem;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem.XReflection
{
    public class _XFieldInfoModel
    {
        public _XFieldInfoModel(_XTypeModel xtype, XFieldInfo field, char key, int index)
        {
            XAccessKey = key;
            XTabIndex = index;
        }

        public char XAccessKey { get; }
        public int XTabIndex { get; }

        public static string XToString(XFieldInfo xfield)
        {
            return _XModel.XToString(xfield.XName);
        }

        public static bool XIsImplicit(XFieldInfo xfield, X x)
        {
            return xfield.XGetCustomAttributes(x.XTypeOf(typeof(_XImplicit)), false).Length > 0;
        }
    }
}
