using _XSystem;
using Microsoft.Extensions.Localization;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem.XReflection
{
    public class _XParameterInfoModel
    {
        public XParameterInfo XParameter { get; }

        public _XParameterInfoModel(XParameterInfo xparam)
        {
            XParameter = xparam;
        }

        public char AccessKey { get; set; }
        public int TabIndex { get; set; }

        public static string XToClass(XParameterInfo xparam)
        {
            return "parameter-info";
        }

        public static string XToData(XParameterInfo xparam)
        {
            return "";
        }

        public static bool XIsImplicit(XParameterInfo xparam, X x)
        {
            return xparam.XGetCustomAttributes(x.XTypeOf(typeof(_XImplicit)), false).Length > 0;
        }
    }
}
