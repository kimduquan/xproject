﻿using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc.ViewFeatures;
using Microsoft.AspNetCore.Routing;
using Microsoft.Extensions.Caching.Memory;
using Microsoft.Extensions.Primitives;
using System;
using System.Collections.Generic;
using XSystem;
using XSystem.XComponentModel;
using XSystem.XComponentModel.XInternal;
using XSystem.XInternal;
using XSystem.XReflection;
using XSystem.XReflection.XInternal;

namespace XWebApplication
{
    public class Util
    {
        private static X x = null;

        public static X X
        {
            get
            {
                if (x == null)
                {
                    x = new XInternal();
                    x.XAssembly = XAssemblyInternal.XNew;
                }
                return x;
            }
        }

        public static void XFromRoute(out XType xtype, RouteData data)
        {
            string dll = (string)data.Values["assembly"];
            dll = dll.Replace('-', '.');
            string ns = (string)data.Values["namespace"];
            ns = ns.Replace('-', '.');
            string t = (string)data.Values["type"];
            xtype = X.XGetType(dll + "." + ns + "." + t + "," + dll);
        }

        public static string XToRoute(XType xtype)
        {
            string[] path = xtype.XFullName.Split(".");
            string dll = path[0];
            string[] ns = new string[path.Length - 2];
            string name = path[path.Length - 1];
            string route = "/" + path[0];
            List<String> temp = new List<String>(path);
            temp.CopyTo(1, ns, 0, path.Length - 2);
            if(ns.Length > 0)
            {
                route = "/" + dll + "/" + string.Join('-', ns) + "/" + name;
            }
            else
            {
                route = "/" + dll + "/" + name;
            }
            return route;
        }

        public static void XToHiearchy(IEnumerator<XType> it, out Dictionary<string, List<string>> childNSs, out Dictionary<string, List<XType>> childTypes)
        {
            childNSs = new Dictionary<string, List<string>>();
            childTypes = new Dictionary<string, List<XType>>();
            while(it.MoveNext())
            {
                if (childTypes.ContainsKey(it.Current.XNamespace))
                {
                    childTypes[it.Current.XNamespace].Add(it.Current);
                }
                else
                {
                    List<XType> types = new List<XType>();
                    types.Add(it.Current);
                    childTypes[it.Current.XNamespace] = types;
                }

                string[] path = it.Current.XNamespace.Split(".");
                string ns = "";
                for(int i = 0; i < path.Length - 1; i++)
                {
                    if (ns.Equals(""))
                    {
                        ns += path[i];
                    }
                    else
                    {
                        ns += ("." + path[i]);
                    }
                    if(childNSs.ContainsKey(ns) == false)
                    {
                        childNSs[ns] = new List<string>();
                        childNSs[ns].Add(path[i + 1]);
                    }
                    else
                    {
                        bool needAdd = true;
                        foreach(string n in childNSs[ns])
                        {
                            if(n.Equals(path[i + 1]))
                            {
                                needAdd = false;
                                break;
                            }
                        }
                        if(needAdd)
                        {
                            childNSs[ns].Add(path[i + 1]);
                        }
                    }
                }
            }
        }

        public static string XToDisplayString(XType type)
        {
            return XToDisplayString(type.XName);
        }

        public static string XToDisplayString(XAssembly a)
        {
            return XToDisplayString(a.XFullName.Split(',')[0]);
        }

        public static string XToDisplayString(XPropertyInfo prop)
        {
            return XToDisplayString(prop.XName);
        }

        public static string XToDisplayString(XParameterInfo p)
        {
            return XToDisplayString(p.XName);
        }

        public static string XToDisplayString(XFieldInfo f)
        {
            return XToDisplayString(f.XName);
        }

        public static string XToDisplayString(string ns)
        {
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
            if(next.MoveNext())
            {
                if (next.MoveNext() && current.MoveNext())
                {
                    while (next.MoveNext() && current.MoveNext() && prev.MoveNext())
                    {
                        if(!ignore)
                        {
                            if(lower)
                                temp += Char.ToLower(prev.Current);
                            else
                                temp += prev.Current;
                        }
                        if (whiteSpace)
                        {
                            temp += ' ';
                        }

                        if ((Char.IsControl(current.Current) && !Char.IsControl(next.Current))
                            || (Char.IsDigit(current.Current) && !Char.IsDigit(next.Current))
                            || (Char.IsLetter(current.Current) && !Char.IsLetter(next.Current))
                            || (Char.IsLetterOrDigit(current.Current) && !Char.IsLetterOrDigit(next.Current))
                            || (Char.IsLower(current.Current) && !Char.IsLower(next.Current))
                            || (Char.IsNumber(current.Current) && !Char.IsNumber(next.Current))
                            )
                        {
                            lower = ignore = whiteSpace = false;
                            whiteSpace = true;
                        }
                        else if((Char.IsWhiteSpace(prev.Current) || whiteSpace) && Char.IsUpper(current.Current))
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
                    if(current.MoveNext())
                        temp += current.Current;
                }
            }
            result = temp;
            return result;
        }

        public static string XToCSSClass(XType type)
        {
            return type.XName.ToLower().Replace('_', '-');
        }

        public static string XToCSSClass(XAssembly a)
        {
            return "assembly";
        }

        public static string XToCSSClass(XParameterInfo p)
        {
            return "parameter-info";
        }

        public static string XToCSSClass(XFieldInfo f)
        {
            return "field-info";
        }

        public static string XToCSSClass(XPropertyInfo p)
        {
            return "property-info";
        }

        public static string XToData(string ns)
        {
            return XToName(ns);
        }

        public static string XToData(XParameterInfo p)
        {
            return XToData(p.XName);
        }

        public static string XToData(XFieldInfo f)
        {
            return XToData(f.XName);
        }

        public static string XToData(XPropertyInfo p)
        {
            return XToData(p.XName);
        }

        public static string XToName(XParameterInfo p)
        {
            return XToName(p.XName);
        }

        public static string XToName(XFieldInfo p)
        {
            return XToName(p.XName);
        }

        public static string XToName(XPropertyInfo p)
        {
            return XToName(p.XName);
        }

        public static string XToName(XType t)
        {
            return XToName(t.XName);
        }

        public static string XToName(string ns)
        {
            return ns.ToLower().Replace('_', '-');
        }

        public static void XFromRoute(out XObject obj,  RouteData data, IMemoryCache cache)
        {
            XType xtype = null;
            XFromRoute(out xtype, data);
            int hashCode = (int)data.Values["hashCode"];
            string key = xtype.XNamespace + "." + "@" + hashCode;
            cache.TryGetValue<XObject>(key, out obj);
        }

        public static void XFromQuery(out List<XType> xtypes, IQueryCollection query)
        {
            xtypes = new List<XType>();
            foreach (KeyValuePair<string, StringValues> pair in query)
            {
                foreach (string value in pair.Value)
                {
                    string dll = value.Split(".")[0];
                    xtypes.Add(X.XTypeOf(Type.GetType(value + "," + dll)));
                }
            }
        }

        public static void XFromForm(out List<XObject> values, XParameterInfo[] xparams, IFormCollection form)
        {
            values = new List<XObject>();
            XTypeConverter converter = new XObjectConverterInternal(X);
            if (converter.XCanConvertFrom(typeof(string)))
            {
                foreach (XParameterInfo xparameter in xparams)
                {
                    StringValues value = form[xparameter.XName];
                    if (converter.XCanConvertTo(xparameter.XParameterType))
                    {
                        values.Add(converter.XConvertTo(value.ToString(), xparameter.XParameterType));
                    }
                }
            }
        }

        public static void XToCache(XObject obj, IMemoryCache cache)
        {
            string key = obj.XGetType().XFullName + "@" + obj.XGetHashCode();
            cache.Set<XObject>(key, obj);
        }

        public static void XToAccessKeyMap(XFieldInfo[] xfields, XPropertyInfo[] xproperties, ViewDataDictionary data, bool isStatic)
        {
            Dictionary<string, char> output = new Dictionary<string, char>();
            Dictionary<char, string> key = new Dictionary<char, string>();
            foreach(XFieldInfo field in xfields)
            {
                if(field.XIsStatic == isStatic)
                {
                    foreach (char ch in field.XName)
                    {
                        if (Char.IsLetterOrDigit(ch))
                        {
                            char temp = Char.ToLower(ch);
                            if (!key.ContainsKey(temp))
                            {
                                key[temp] = field.XName;
                                output[field.XName] = temp;
                                break;
                            }
                        }
                    }
                }
            }
            foreach (XPropertyInfo prop in xproperties)
            {
                foreach (char ch in prop.XName)
                {
                    if (Char.IsLetterOrDigit(ch))
                    {
                        char temp = Char.ToLower(ch);
                        if (!key.ContainsKey(temp))
                        {
                            key[temp] = prop.XName;
                            output[prop.XName] = temp;
                            break;
                        }
                    }
                }
            }
            data["accesskey"] = output;
        }

        public static void XToAccessKeyMap(XParameterInfo[] xparams, ViewDataDictionary data)
        {
            Dictionary<string, char> output = new Dictionary<string, char>();
            Dictionary<char, string> key = new Dictionary<char, string>();
            foreach (XParameterInfo xparam in xparams)
            {
                foreach (char ch in xparam.XName)
                {
                    if (Char.IsLetterOrDigit(ch))
                    {
                        char temp = Char.ToLower(ch);
                        if (!key.ContainsKey(temp))
                        {
                            key[temp] = xparam.XName;
                            output[xparam.XName] = temp;
                            break;
                        }
                    }
                }
            }
            data["accesskey"] = output;
        }

        public static string XToAccessKey(XPropertyInfo p, ViewDataDictionary data)
        {
            Dictionary<string, char> keyMap = data["accesskey"] as Dictionary<string, char>;
            if (keyMap.ContainsKey(p.XName))
                return "" + keyMap[p.XName];
            return "";
        }

        public static string XToAccessKey(XFieldInfo f, ViewDataDictionary data)
        {
            Dictionary<string, char> keyMap = data["accesskey"] as Dictionary<string, char>;
            if (keyMap.ContainsKey(f.XName))
                return "" + keyMap[f.XName];
            return "";
        }

        public static string XToAccessKey(XParameterInfo p, ViewDataDictionary data)
        {
            Dictionary<string, char> keyMap = data["accesskey"] as Dictionary<string, char>;
            if (keyMap.ContainsKey(p.XName))
                return "" + keyMap[p.XName];
            return "";
        }

        public static void XToViewData(XType t, ViewDataDictionary data)
        {
            data["XType"] = t;
        }

        public static void XToViewData(XObject o, ViewDataDictionary data)
        {
            data["XObject"] = o;
        }

        public static void XToViewData(XMethodInfo m, ViewDataDictionary data)
        {
            data["XMethodInfo"] = m;
        }

        public static void XToViewData(XConstructorInfo c, ViewDataDictionary data)
        {
            data["XConstructorInfo"] = c;
        }

        public static void XFromViewData(out XType t, ViewDataDictionary data)
        {
            t = data["XType"] as XType;
        }

        public static void XFromViewData(out XObject o, ViewDataDictionary data)
        {
            o = data["XObject"] as XObject;
        }

        public static void XFromViewData(out XMethodInfo m, ViewDataDictionary data)
        {
            m = data["XMethodInfo"] as XMethodInfo;
        }

        public static void XFromViewData(out XConstructorInfo c, ViewDataDictionary data)
        {
            c = data["XConstructorInfo"] as XConstructorInfo;
        }

        public static void XToTabIndexMap(XFieldInfo[] xfields, XPropertyInfo[] xprops, ViewDataDictionary data, bool isStatic)
        {
            Dictionary<string, int> output = new Dictionary<string, int>();
            int index = 0;
            foreach (XFieldInfo field in xfields)
            {
                if (field.XIsStatic == isStatic)
                {
                    output[field.XName] = index;
                    index++;
                }
            }
            foreach (XPropertyInfo prop in xprops)
            {
                output[prop.XName] = index;
                index++;
            }
            data["tabindex"] = output;
        }

        public static string XToTabIndex(XPropertyInfo p, ViewDataDictionary data)
        {
            Dictionary<string, int> indexMap = data["tabindex"] as Dictionary<string, int>;
            if (indexMap.ContainsKey(p.XName))
                return "" + indexMap[p.XName];
            return "";
        }

        public static string XToTabIndex(XFieldInfo f, ViewDataDictionary data)
        {
            Dictionary<string, int> indexMap = data["tabindex"] as Dictionary<string, int>;
            if (indexMap.ContainsKey(f.XName))
                return "" + indexMap[f.XName];
            return "";
        }

        public static string XToTabIndex(XParameterInfo p, ViewDataDictionary data)
        {
            Dictionary<string, int> indexMap = data["tabindex"] as Dictionary<string, int>;
            if (indexMap.ContainsKey(p.XName))
                return "" + indexMap[p.XName];
            return "";
        }
    }
}
