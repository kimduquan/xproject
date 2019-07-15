using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Primitives;
using System.Collections.Generic;
using XSystem;
using XSystem.XComponentModel;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem.XReflection
{
    public class _XMethodInfoModel
    {
        public XParameterInfo[] XParameters { get; set; }
        public List<char> XAccessKeys { get; set; }

        public static void XToAccessKeyMap(XParameterInfo[] xparams, out Dictionary<string, char> accessKeyMap, out List<char> accessKeys)
        {
            List<string> names = new List<string>();
            foreach (XParameterInfo xparam in xparams)
            {
                names.Add(xparam.XName);
            }
            _XModel.XToAccessKeyMap(names.ToArray(), out accessKeyMap, out accessKeys);
        }

        public static string XToHref(XType xtype, XMethodInfo method)
        {
            return _XTypeModel.XToHref(xtype) + "/" + method.XName;
        }

        public static string XToString(XMethodInfo method)
        {
            return _XModel.XToString(method.XName);
        }

        public static XObject[] XFromForm(XParameterInfo[] xparams, XTypeConverter xtypeConverter, IFormCollection form, _XThisCache cache)
        {
            List<XObject>  values = new List<XObject>();
            if (xtypeConverter.XCanConvertFrom(typeof(string)))
            {
                foreach (XParameterInfo xparameter in xparams)
                {
                    StringValues value = form[xparameter.XName];
                    if (xtypeConverter.XCanConvertTo(xparameter.XParameterType))
                    {
                        values.Add(xtypeConverter.XConvertTo(value.ToString(), xparameter.XParameterType));
                    }
                    else if (cache != null)
                    {
                        values.Add(cache.XObject(value.ToString()));
                    }
                }
            }
            return values.ToArray();
        }
    }
}
