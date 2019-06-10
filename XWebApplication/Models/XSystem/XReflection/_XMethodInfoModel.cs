using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem.XReflection
{
    public class _XMethodInfoModel
    {
        public XMethodInfo XMethod { get; }

        public _XMethodInfoModel(XMethodInfo m)
        {
            XMethod = m;
        }

        public static string XToHref(XType xtype, XMethodInfo method)
        {
            return _XTypeModel.XToHref(xtype) + "/" + method.XName;
        }

        public static string XToString(XMethodInfo method)
        {
            return _XModel.XToString(method.XName);
        }
    }
}
