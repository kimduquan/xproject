﻿using _XSystem;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Caching.Memory;
using Microsoft.Extensions.Localization;
using System.Collections.Generic;
using System.Reflection;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem
{
    public class _XStringModel
    {
        protected static string XToString(string ns, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                string key = ns.Replace('.', '_');
                string value = xstring[key];
                if (key != value)
                    return value;
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

        public static string XToString(string key, string defValue, IStringLocalizer xstring)
        {
            string value = defValue;
            if (xstring != null)
            {
                value = xstring[key];
                if (key == value)
                {
                    value = XToString(defValue, xstring);
                }
            }
            else
            {
                value = XToString(defValue, xstring);
            }
            return value;
        }

        public static string XToKey(XType xtype)
        {
            string key = xtype.XFullName.Replace('.', '_');
            return key;
        }
        protected static string XToKey(XAssembly xassembly)
        {
            string key = xassembly.XFullName.Replace('.', '_');
            return key;
        }
        protected static string XToKey(XFieldInfo xfield)
        {
            string key = (xfield.XDeclaringType.XFullName + "." + xfield.XName).Replace('.', '_');
            return key;
        }
        protected static string XToKey(XMethodInfo xmethod)
        {
            string key = (xmethod.XDeclaringType.XFullName + "." + xmethod.XName).Replace('.', '_');
            return key;
        }
        protected static string XToKey(XParameterInfo xparam)
        {
            string key = (xparam.XParameterType.XFullName + "." + xparam.XName).Replace('.', '_');
            return key;
        }
        protected static string XToKey(XPropertyInfo xproperty)
        {
            string key = (xproperty.XDeclaringType.XFullName + "." + xproperty.XName).Replace('.', '_');
            return key;
        }

        public static string XToString(XType xtype, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                string key = XToKey(xtype);
                string value = xstring[key];
                if (key != value)
                    return value;
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

        public static string XToString(XAssembly xassembly, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                string key = XToKey(xassembly);
                string value = xstring[key];
                if (key != value)
                    return value;
            }
            return XToString(xassembly.XFullName.Split(',')[0], xstring);
        }

        public static string XToString(XFieldInfo xfield, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                string key = XToKey(xfield);
                string value = xstring[key];
                if (key != value)
                    return value;
            }
            return XToString(xfield.XName, xstring);
        }

        public static string XToString(XMethodInfo xmethod, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                string key = XToKey(xmethod);
                string value = xstring[key];
                if (key != value)
                    return value;
            }
            return XToString(xmethod.XName, xstring);
        }

        public static string XToString(XParameterInfo xparam, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                string key = XToKey(xparam);
                string value = xstring[key];
                if (key != value)
                    return value;
            }
            return XToString(xparam.XName, xstring);
        }

        public static string XToString(XPropertyInfo xprop, IStringLocalizer xstring)
        {
            if (xstring != null)
            {
                string key = XToKey(xprop);
                string value = xstring[key];
                if (key != value)
                    return value;
            }
            return XToString(xprop.XName, xstring);
        }

        public IStringLocalizer XString { get; } 

        protected _XStringModel(IStringLocalizer xstr)
        {
            XString = xstr;
        }

        public static IStringLocalizer XFromSession(IMemoryCache cache, ISession session)
        {
            IStringLocalizer stringLocalizer = null;
            string key = session.GetString("string");
            if(key != null)
            {
                _XStringModel xstring = null;
                if (cache.TryGetValue(key, out xstring) && xstring != null)
                {
                    stringLocalizer = xstring.XString;
                }
            }
            return stringLocalizer;
        }

        public static IStringLocalizer XToCache(XAssembly xassembly, IMemoryCache cache, ISession session, IStringLocalizerFactory factory)
        {
            AssemblyName name = new AssemblyName(xassembly.XFullName);
            IStringLocalizer stringLocalizer = factory.Create("Properties.Resources", name.Name);
            _XStringModel xstring = new _XStringModel(stringLocalizer);
            string key = typeof(_XStringModel).FullName + "#" + xstring.GetHashCode();
            using (ICacheEntry entry = cache.CreateEntry(key))
            {
                entry.SetValue(xstring);
            }
            session.SetString("string", key);
            return stringLocalizer;
        }

        public static void XReturn(IMemoryCache cache, ISession session)
        {
            string key = session.GetString("string");
            cache.Remove(key);
            session.Remove("string");
        }

        protected static bool XToTitle(XObject[] xattributes, out string title)
        {
            bool res = false;
            title = null;
            foreach (XObject attr in xattributes)
            {
                if (attr.X is _XString xattr)
                {
                    title = xattr.XString;
                    res = true;
                }
            }
            return res;
        }

        public static string XToTitle(XType xtype, IStringLocalizer xstring)
        {
            string key = XToKey(xtype);
            key += ("_" + "string");
            string value = xstring[key];
            if(key == value)
            {
                if (XToTitle(xtype.XGetCustomAttributes(), out value) == false)
                {
                    value = "";
                }
            }
            return value;
        }
    }
}
