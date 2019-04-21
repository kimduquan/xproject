using _XSystem;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc.ViewFeatures;
using Microsoft.AspNetCore.Routing;
using Microsoft.Extensions.Caching.Memory;
using Microsoft.Extensions.Primitives;
using System;
using System.Collections.Generic;
using System.Security.Claims;
using XSystem;
using XSystem.XComponentModel;
using XSystem.XComponentModel.XInternal;
using XSystem.XInternal;
using XSystem.XReflection;
using XSystem.XReflection.XInternal;

namespace XWebApplication
{
    public class XUtil
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

        public static void XToHiearchy(List<XType> xtypes, out Dictionary<string, List<string>> childNSs, out Dictionary<string, List<XType>> childTypes)
        {
            childNSs = new Dictionary<string, List<string>>();
            childTypes = new Dictionary<string, List<XType>>();
            using (IEnumerator<XType> it = xtypes.GetEnumerator())
            {
                while (it.MoveNext())
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
                    for (int i = 0; i < path.Length - 1; i++)
                    {
                        if (ns.Equals(""))
                        {
                            ns += path[i];
                        }
                        else
                        {
                            ns += ("." + path[i]);
                        }
                        if (childNSs.ContainsKey(ns) == false)
                        {
                            childNSs[ns] = new List<string>();
                            childNSs[ns].Add(path[i + 1]);
                        }
                        else
                        {
                            bool needAdd = true;
                            foreach (string n in childNSs[ns])
                            {
                                if (n.Equals(path[i + 1]))
                                {
                                    needAdd = false;
                                    break;
                                }
                            }
                            if (needAdd)
                            {
                                childNSs[ns].Add(path[i + 1]);
                            }
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

        public static string XToDisplayString(XObject o)
        {
            return XToDisplayString(o.XGetType()) + " #" + o.XGetHashCode();
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

        public static void XToSession(XObject xobject, ISession session)
        {
            session.SetString("this", xobject.XGetType().XFullName + "@" + xobject.XGetHashCode());
        }

        public static void XToCache(XObject obj, IMemoryCache cache, ISession session)
        {
            Dictionary<string, XObject> xobjects = null;
            XGetCache(cache, session, out xobjects);
            string key = obj.XGetType().XFullName + "@" + obj.XGetHashCode();
            xobjects.TryAdd(key, obj);
        }

        protected static void XGetCache(IMemoryCache cache, ISession session, out Dictionary<string, XObject> xobjects)
        {
            string xthis = session.GetString("this");
            if (cache.TryGetValue(xthis, out xobjects) == false)
            {
                xobjects = new Dictionary<string, XObject>();
                using (ICacheEntry entry = cache.CreateEntry(xthis))
                {
                    entry.SetValue(xobjects);
                }
            }
        }

        public static void XFromCache(out XObject obj, IMemoryCache cache, ISession session, string type, int hashCode)
        {
            Dictionary<string, XObject> xobjects = null;
            XGetCache(cache, session, out xobjects);
            string key = type + "@" + hashCode;
            xobjects.TryGetValue(key, out obj);
        }

        public static void XFromCache(out XObject obj, IMemoryCache cache, ISession session)
        {
            Dictionary<string, XObject> xobjects = null;
            XGetCache(cache, session, out xobjects);
            string xthis = session.GetString("this");
            xobjects.TryGetValue(xthis, out obj);
        }

        public static void XToAccessKeyMap(XFieldInfo[] xfields, XPropertyInfo[] xproperties, ViewDataDictionary data)
        {
            Dictionary<string, char> output = new Dictionary<string, char>();
            Dictionary<char, string> key = new Dictionary<char, string>();
            foreach(XFieldInfo field in xfields)
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

        public static void XToViewData(XAssembly a, ViewDataDictionary data)
        {
            data["XAssembly"] = a;
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

        public static void XFromViewData(out XAssembly a, ViewDataDictionary data)
        {
            a = data["XAssembly"] as XAssembly;
        }

        public static void XToTabIndexMap(XFieldInfo[] xfields, XPropertyInfo[] xprops, ViewDataDictionary data)
        {
            Dictionary<string, int> output = new Dictionary<string, int>();
            int index = 0;
            foreach (XFieldInfo field in xfields)
            {
                output[field.XName] = index;
                index++;
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

        public static void XToFieldSet(XFieldInfo[] xfields, out List<XType> xtypes, out Dictionary<string, List<XFieldInfo>> xfieldSet, bool isStatic)
        {
            xtypes = new List<XType>();
            xfieldSet = new Dictionary<string, List<XFieldInfo>>();
            foreach (XFieldInfo xfield in xfields)
            {
                if(xfield.XIsStatic == isStatic)
                {
                    if (xfieldSet.ContainsKey(xfield.XDeclaringType.XFullName) == false)
                    {
                        xtypes.Add(xfield.XDeclaringType);
                        List<XFieldInfo> list = new List<XFieldInfo>();
                        list.Add(xfield);
                        xfieldSet[xfield.XDeclaringType.XFullName] = list;
                    }
                    else
                    {
                        xfieldSet[xfield.XDeclaringType.XFullName].Add(xfield);
                    }
                }
            }
        }

        public static void XToPropertySet(XPropertyInfo[] xprops, out List<XType> xtypes, out Dictionary<string, List<XPropertyInfo>> xpropSet, bool isStatic)
        {
            xtypes = new List<XType>();
            xpropSet = new Dictionary<string, List<XPropertyInfo>>();
            foreach (XPropertyInfo xprop in xprops)
            {
                if(xprop.XIsStatic == isStatic)
                {
                    if (xpropSet.ContainsKey(xprop.XDeclaringType.XFullName) == false)
                    {
                        xtypes.Add(xprop.XDeclaringType);
                        List<XPropertyInfo> list = new List<XPropertyInfo>();
                        list.Add(xprop);
                        xpropSet[xprop.XDeclaringType.XFullName] = list;
                    }
                    else
                    {
                        xpropSet[xprop.XDeclaringType.XFullName].Add(xprop);
                    }
                }
            }
        }

        public static void XToFields(List<XType> xtypes, Dictionary<string, List<XFieldInfo>> xfieldSet, out List<XFieldInfo> xoutFields)
        {
            xoutFields = new List<XFieldInfo>();
            foreach(XType xtype in xtypes)
            {
                xoutFields.AddRange(xfieldSet[xtype.XFullName]);
            }
        }

        public static void XToProperties(List<XType> xtypes, Dictionary<string, List<XPropertyInfo>> xpropSet, out List<XPropertyInfo> xoutProps)
        {
            xoutProps = new List<XPropertyInfo>();
            foreach (XType xtype in xtypes)
            {
                xoutProps.AddRange(xpropSet[xtype.XFullName]);
            }
        }

        public static void XToData(XFieldInfo[] xfields, XObject xobject, out Dictionary<string, List<string>> data)
        {
            data = new Dictionary<string, List<string>>();
            foreach(XFieldInfo xfield in xfields)
            {
                List<string> list = null;
                XToData(xfield, xobject, out list);
                data[XToName(xfield)] = list;
            }
        }

        protected static void XToData(XFieldInfo xfield, XObject xobject, out List<string> data)
        {
            data = new List<string>();
            if(xfield.XFieldType.XIsArray)
            {
                XArray xarray = null;
                if(xobject != null)
                    xarray = xfield.XGetValue(xobject) as XArray;
                else
                    xarray = xfield.XGetValue(X.XNULL) as XArray;
                if (xarray != null)
                {
                    for (int i = 0; i < xarray.XLength; i++)
                    {
                        data.Add(xarray.XGetValue(i).XToString());
                    }
                }
            }
            else
            {
                if(xobject != null)
                    data.Add(xfield.XGetValue(xobject).XToString());
                else
                    data.Add(xfield.XGetValue(X.XNULL).XToString());
            }
        }

        public static void XToData(XPropertyInfo[] xprops, XObject xobject, out Dictionary<string, List<string>> data)
        {
            data = new Dictionary<string, List<string>>();
            foreach (XPropertyInfo xprop in xprops)
            {
                List<string> list = null;
                XToData(xprop, xobject, out list);
                data[XToName(xprop)] = list;
            }
        }

        protected static void XToData(XPropertyInfo xprop, XObject xobject, out List<string> data)
        {
            data = new List<string>();
            if (xprop.XPropertyType.XIsArray)
            {
                XArray xarray = null;
                if (xobject != null)
                    xarray = xprop.XGetValue(xobject) as XArray;
                else
                    xarray = xprop.XGetValue(X.XNULL) as XArray;
                if (xarray != null)
                {
                    for (int i = 0; i < xarray.XLength; i++)
                    {
                        data.Add(xarray.XGetValue(i).XToString());
                    }
                }
            }
            else
            {
                if (xobject != null)
                    data.Add(xprop.XGetValue(xobject).XToString());
                else
                    data.Add(xprop.XGetValue(X.XNULL).XToString());
            }
        }

        public static void XToAbout(XAssembly assemly, out Dictionary<string, string> about)
        {
            about = new Dictionary<string, string>();
            foreach(XAttribute xattr in assemly.XGetCustomAttributes())
            {
                if (xattr.XGetType().XName.StartsWith("Assembly") && xattr.XGetType().XName.EndsWith("Attribute") && xattr.XGetType().XNamespace == "System.Reflection")
                {
                    string attr = xattr.XGetType().XName;
                    attr = attr.Substring("Assembly".Length);
                    attr = attr.Substring(0, attr.Length - "Attribute".Length);
                    XPropertyInfo xprop = xattr.XGetType().XGetProperty(attr);
                    if (xprop != null && xprop.XIsStatic == false)
                    {
                        about[attr] = xprop.XGetValue(xattr).XToString();
                    }
                }
            }
        }

        public static void XFromReturnUrl(IQueryCollection query, out XType xtype, out string url)
        {
            xtype = null;
            StringValues returnUrl;
            query.TryGetValue("ReturnUrl", out returnUrl);
            url = returnUrl.ToString();
            string[] path = url.Split("/");
            if(path.Length > 3)
            {
                string dll = path[1];
                string ns = string.Join(".", path, 1, path.Length - 1).Replace('-', '.');
                xtype = X.XGetType(ns + "," + dll);
            }
        }

        public static void XGetEntryType(XAssembly xassembly, out XType xtype)
        {
            xtype = null;
            foreach (XType t in xassembly.XExportedTypes)
            {
                if(t.XName == t.XNamespace && t.XName == t.XAssembly.XFullName.Split(',')[0])
                {
                    xtype = t;
                    break;
                }
            }
        }

        public static void XGetEntryMethods(XType xtype, out XMethodInfo[] xmethodInfos)
        {
            List<XMethodInfo> result = new List<XMethodInfo>();
            foreach(XMethodInfo xmethod in xtype.XGetMethods())
            {
                if(xmethod.XReturnType != null && xmethod.XDeclaringType.XNamespace != "System" && xmethod.XReturnType.XIsPrimitive == false && xmethod.XReturnType.XIsArray  == false)
                {
                    bool check = true;
                    foreach(XParameterInfo xparam in xmethod.XGetParameters())
                    {
                        if(xparam.XParameterType.XIsArray || xparam.XParameterType.XNamespace != "System")
                        {
                            check = false;
                            break;
                        }
                    }
                    if(check)
                    {
                        result.Add(xmethod);
                    }
                }
            }
            xmethodInfos = result.ToArray();
        }

        public static void XToHref(XObject xobject, out string href)
        {
            string[] path = xobject.XGetType().XFullName.Split(".");
            href = string.Format("/{0}/{1}/{2}/{3}", 
                path[0], 
                string.Join('-', path, 1, path.Length - 2), 
                path[path.Length - 1], 
                "" + xobject.XGetHashCode()
            );
        }

        public static void XFromName(string fullName, out XType xtype)
        {
            xtype = X.XGetType(fullName + "," + fullName.Split('.')[0]);
        }

        public static bool XImplicit(XParameterInfo xparam)
        {
            return xparam.XGetCustomAttributes(X.XTypeOf(typeof(_XImplicit)), false).Length > 0;
        }

        public static bool XImplicit(XFieldInfo xfield)
        {
            return xfield.XGetCustomAttributes(X.XTypeOf(typeof(_XImplicit)), true).Length > 0;
        }

        public static bool XImplicit(XPropertyInfo xproperty)
        {
            return xproperty.XGetCustomAttributes(X.XTypeOf(typeof(_XImplicit)), true).Length > 0;
        }

        public static void XCalculateGoldenRatio(bool dir, int start, int length, out List<int> pages)
        {
            double goldenRatio = 0.618;
            pages = new List<int>();
            int sum = length - start;
            int big = 0;
            int small = 0;
            do
            {
                big = (int)(sum * goldenRatio);
                small = (int)(big * goldenRatio);
                if (dir)
                {

                }
            }
            while (sum > big && big > small && small > 0);
        }

        public static void XCheckCustomAttribute(XType xthis, XType xtype, out bool isCustom, out bool success)
        {
            isCustom = false;
            success = false;
            foreach (XObject attr in xthis.XGetCustomAttributes())
            {
                if (attr.X is _XType xattr)
                {
                    isCustom = true;
                    if (xattr.XType.FullName == xtype.XFullName)
                    {
                        success = true;
                        break;
                    }
                }
            }
        }

        public static void XFromClaims(ClaimsPrincipal user, out XType xtype)
        {
            xtype = null;
            if (user.HasClaim(c => c.Type == "Type"))
            {
                Claim t = user.FindFirst(c => c.Type == "Type");
                XFromName(t.Value, out xtype);
            }
        }

        public static void XAuthorize(RouteData routeData, ClaimsPrincipal user, out bool success)
        {
            success = false;
            XType xtype = null;
            XFromRoute(out xtype, routeData);
            XType xthis = null;
            XFromClaims(user, out xthis);
            XAuthorize(xthis, xtype, out success);
        }

        protected static void XAuthorize(XType xthis, XType xtype, out bool success)
        {
            success = false;
            bool isCustom = false;
            if (xtype != null && xthis != null)
            {
                if (xtype.XEqual(xthis))
                {
                    success = true;
                }
                else
                {
                    XCheckCustomAttribute(xthis, xtype, out isCustom, out success);
                    if (isCustom == false || success == false)
                    {
                        XCheckCustomAttribute(xtype, xthis, out isCustom, out success);
                        if (isCustom == false)
                        {
                            success = true;
                        }
                    }
                }
            }
        }

        public static void XAuthorize(XType xthis, IEnumerable<XType> xtypes, out List<XType> result)
        {
            result = new List<XType>();
            using (IEnumerator<XType> it = xtypes.GetEnumerator())
            {
                while (it.MoveNext())
                {
                    if(it.Current.XIsPublic && it.Current.XIsAbstract == false)
                    {
                        bool success = false;
                        XAuthorize(xthis, it.Current, out success);
                        if (success)
                            result.Add(it.Current);
                    }
                };
            }
        }
    }
}
