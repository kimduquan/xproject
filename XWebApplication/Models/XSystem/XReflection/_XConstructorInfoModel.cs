using XSystem;
using XSystem.XReflection;
using XWebApplication.Util;

namespace XWebApplication.Models.XSystem.XReflection
{
    public class _XConstructorInfoModel
    {
        public static string XToHref(XType xtype, XConstructorInfo ctor)
        {
            return _XTypeModel.XToHref(xtype) + "/" + XConstants.XNEW;
        }
    }
}
