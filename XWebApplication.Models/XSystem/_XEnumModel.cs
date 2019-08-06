using Microsoft.Extensions.Localization;
using XSystem;

namespace XWebApplication.Models.XSystem
{
    public class _XEnumModel
    {
        public static string XToString(XType xtype, string enumName, IStringLocalizer xstring)
        {
            string key = _XStringModel.XToKey(xtype);
            key += ("_" + enumName);
            string value = _XStringModel.XToString(key, enumName, xstring);
            return value;
        }
    }
}
