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
            return null;
        }

        public static string XToString(XMethodInfo method)
        {
            return null;
        }
    }
}
