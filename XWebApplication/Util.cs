using Microsoft.AspNetCore.Http;
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

        public static XAssembly XGetAssembly(XType xtype)
        {
            return new XAssemblyInternal(xtype.X.Assembly, X);
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
            string result = "";
            IEnumerator<char> ci = ns.GetEnumerator();
            IEnumerator<char> cj = ns.GetEnumerator();
            if(cj.MoveNext())
            {
                while (ci.MoveNext() && cj.MoveNext())
                {
                    result += ci.Current;
                    if ((Char.IsControl(ci.Current) && !Char.IsControl(cj.Current))
                        || (Char.IsDigit(ci.Current) && !Char.IsDigit(cj.Current))
                        || (Char.IsLetter(ci.Current) && !Char.IsLetter(cj.Current))
                        || (Char.IsLetterOrDigit(ci.Current) && !Char.IsLetterOrDigit(cj.Current))
                        || (Char.IsLower(ci.Current) && !Char.IsLower(cj.Current))
                        || (Char.IsNumber(ci.Current) && !Char.IsNumber(cj.Current))
                        )
                    {
                        result += " ";
                    }
                }
                result += ci.Current;
            }
            result = result.Replace('.', ' ');
            result = result.Replace('_', ' ');
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

        public static string XToAttribute(string name, XAssembly a)
        {
            if (name == "class")
                return "assembly";
            return "";
        }
    }
}
