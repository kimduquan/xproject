using Microsoft.Extensions.Localization;
using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem
{
    public class _XStringModel
    {
        public static string XToString(string ns, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                return xstring[ns];
            }

            string result = ns;
            result = result.Replace('.', ' ');
            result = result.Replace('_', ' ');
            result = result.Trim();
            IEnumerator<char> current = result.GetEnumerator();
            IEnumerator<char> next = result.GetEnumerator();
            IEnumerator<char> prev = result.GetEnumerator();
            bool lower = false;
            bool whiteSpace = false;
            bool ignore = false;
            string temp = "";
            if (next.MoveNext())
            {
                if (next.MoveNext() && current.MoveNext())
                {
                    while (next.MoveNext() && current.MoveNext() && prev.MoveNext())
                    {
                        if (!ignore)
                        {
                            if (lower)
                                temp += char.ToLower(prev.Current);
                            else
                                temp += prev.Current;
                        }
                        if (whiteSpace)
                        {
                            temp += ' ';
                        }

                        if ((char.IsControl(current.Current) && !char.IsControl(next.Current))
                            || (char.IsDigit(current.Current) && !char.IsDigit(next.Current))
                            || (char.IsLetter(current.Current) && !char.IsLetter(next.Current))
                            || (char.IsLetterOrDigit(current.Current) && !char.IsLetterOrDigit(next.Current))
                            || (char.IsLower(current.Current) && !char.IsLower(next.Current))
                            || (char.IsNumber(current.Current) && !char.IsNumber(next.Current))
                            )
                        {
                            lower = ignore = whiteSpace = false;
                            whiteSpace = true;
                        }
                        else if ((char.IsWhiteSpace(prev.Current) || whiteSpace) && char.IsUpper(current.Current))
                        {
                            lower = ignore = whiteSpace = false;
                            lower = true;
                        }
                        else
                        {
                            lower = ignore = whiteSpace = false;
                        }
                    }
                    if (prev.MoveNext())
                        temp += prev.Current;
                    if (current.MoveNext())
                        temp += current.Current;
                }
            }
            result = temp;
            return result;
        }

        public static string XToString(XType xtype, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                return xstring[xtype.XFullName];
            }
            return XToString(xtype.XName, xstring);
        }

        public static string XToString(XObject xobject, IStringLocalizer xstring)
        {
            string str = xobject.XToString();
            if(xstring != null)
            {
                str = xstring[str];
            }
            return str;
        }

        public static string XToString(XAssembly assembly, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                string key = assembly.XFullName.Split(',')[0];
                return xstring[key];
            }
            return XToString(assembly.XFullName.Split(',')[0], xstring);
        }

        public static string XToString(XFieldInfo xfield, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                string key = xfield.XDeclaringType.XFullName + "." + xfield.XName;
                return xstring[key];
            }
            return XToString(xfield.XName, xstring);
        }

        public static string XToString(XMethodInfo method, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                string key = method.XDeclaringType.XFullName + "." + method.XName;
                return xstring[key];
            }
            return XToString(method.XName, xstring);
        }

        public static string XToString(XParameterInfo xparam, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                string key = xparam.XName;
                return xstring[key];
            }
            return XToString(xparam.XName, xstring);
        }

        public static string XToString(XPropertyInfo xprop, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                string key = xprop.XDeclaringType.XFullName + "." + xprop.XName;
                return xstring[key];
            }
            return XToString(xprop.XName, xstring);
        }
    }
}
