using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem.XReflection
{
    public class _XConstructorInfoModel
    {
        public XParameterInfo[] XParameters { get; set; }
        public List<char> XAccessKeys { get; set; }

        public static string XToHref(XType xtype, XConstructorInfo ctor)
        {
            return _XTypeModel.XToHref(xtype) + "/" + XConstants.XNEW;
        }
    }
}
