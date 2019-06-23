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
            accessKeyMap = new Dictionary<string, char>();
            accessKeys = new List<char>();
            Dictionary<char, string> usedKeys = new Dictionary<char, string>();
            foreach (XParameterInfo xparam in xparams)
            {
                char key = ' ';
                foreach (char ch in xparam.XName)
                {
                    if (char.IsLetterOrDigit(ch))
                    {
                        char temp = char.ToLower(ch);
                        if (!usedKeys.ContainsKey(temp))
                        {
                            usedKeys[temp] = xparam.XName;
                            accessKeyMap[xparam.XName] = temp;
                            key = temp;
                            break;
                        }
                    }
                }
                accessKeys.Add(key);
            }
        }

        public static string XToHref(XType xtype, XMethodInfo method)
        {
            return _XTypeModel.XToHref(xtype) + "/" + method.XName;
        }

        public static string XToString(XMethodInfo method)
        {
            return _XModel.XToString(method.XName);
        }

        public static XObject[] XFromForm(XMethodInfo xmethod, IFormCollection form, Dictionary<string, XObject> xobjects)
        {
            XParameterInfo[] xparams = xmethod.XGetParameters();
            List<XObject>  values = new List<XObject>();
            XTypeConverter converter = _XModel.XNewConverter();
            if (converter.XCanConvertFrom(typeof(string)))
            {
                foreach (XParameterInfo xparameter in xparams)
                {
                    StringValues value = form[xparameter.XName];
                    if (converter.XCanConvertTo(xparameter.XParameterType))
                    {
                        values.Add(converter.XConvertTo(value.ToString(), xparameter.XParameterType));
                    }
                    else if (xobjects != null)
                    {
                        string key = value.ToString().Replace('#', '@');
                        if (xobjects.ContainsKey(key))
                        {
                            values.Add(xobjects[key]);
                        }
                    }
                }
            }
            return values.ToArray();
        }
    }
}
