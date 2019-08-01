using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Routing;
using Microsoft.Extensions.Localization;
using Microsoft.Extensions.Primitives;
using System.Collections.Generic;
using System.Security.Claims;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem
{
    public class _XTypeModel : _XModel
    {
        public _XTypeModel(XType type, _XThisCache xthis): base(xthis)
        {
            XType = type;
        }

        public XConstructorInfo[] XConstructors { get; set; }
        public XMethodInfo[] XMethods { get; set; }
        public XType XType { get; }
        public Dictionary<string, List<XFieldInfo>> XFields { get; set; }
        public List<XType> XFieldTypes { get; set; }
        public Dictionary<string, List<XPropertyInfo>> XProperties { get; set; }
        public List<XType> XPropertyTypes { get; set; }

        public static string XToHref(XType xtype)
        {
            string[] path = xtype.XFullName.Split(".");
            string dll = path[0];
            string ns = "";
            if(path.Length > 2)
            {
                ns = string.Join('-', path, 1, path.Length - 2);
            }
            string name = path[path.Length - 1];
            string href = "";
            if (ns.Length > 0)
            {
                href = string.Format("/{0}/{1}/{2}", dll, ns, name);
            }
            else
            {
                href = string.Format("/{0}/{1}/", dll, name);
            }
            return href;
        }

        public static XType XFromReturnUrl(X x, IQueryCollection query, out string url)
        {
            XType xtype = null;
            StringValues returnUrl;
            query.TryGetValue("ReturnUrl", out returnUrl);
            url = returnUrl.ToString();
            if(url.EndsWith("/"))
            {
                url = url.TrimEnd('/');
            }
            if(url.StartsWith("/"))
            {
                url = url.TrimStart('/');
            }
            string[] path = url.Split("/");
            if (path.Length > 2)
            {
                string dll = path[0];
                string ns = string.Join(".", path, 0, 3).Replace('-', '.');
                xtype = x.XGetType(ns + "," + dll);
            }
            return xtype;
        }

        public static XMethodInfo[] XGetEntryMethods(XType xtype)
        {
            List<XMethodInfo> result = new List<XMethodInfo>();
            foreach (XMethodInfo xmethod in xtype.XGetMethods())
            {
                if (xmethod.XReturnType != null && xmethod.XDeclaringType.XNamespace != "System" && xmethod.XReturnType.XIsPrimitive == false && xmethod.XReturnType.XIsArray == false)
                {
                    bool check = true;
                    foreach (XParameterInfo xparam in xmethod.XGetParameters())
                    {
                        if (xparam.XParameterType.XIsArray || xparam.XParameterType.XNamespace != "System")
                        {
                            check = false;
                            break;
                        }
                    }
                    if (check)
                    {
                        result.Add(xmethod);
                    }
                }
            }
            XMethodInfo[] xmethodInfos = result.ToArray();
            return xmethodInfos;
        }

        public static XType XFromFullName(string fullName, X x)
        {
            XType xtype = x.XGetType(fullName + "," + fullName.Split('.')[0]);
            return xtype;
        }
        
        public static string XToCssClass(XType xtype)
        {
            return xtype.XName.ToLower().Replace('_', '-');
        }

        public static XType XFromRoute(RouteData data, X x)
        {
            string dll = (string)data.Values["assembly"];
            dll = dll.Replace('-', '.');
            string ns = (string)data.Values["namespace"];
            ns = ns.Replace('-', '.');
            string t = (string)data.Values["type"];
            XType xtype = x.XGetType(dll + "." + ns + "." + t + "," + dll);
            return xtype;
        }

        public static XType XFromUser(ClaimsPrincipal user, X x)
        {
            XType xtype = null;
            if (user.HasClaim(c => c.Type == "Type"))
            {
                Claim t = user.FindFirst(c => c.Type == "Type");
                xtype = XFromFullName(t.Value, x);
            }
            return xtype;
        }

        public static bool XCheckXTypeAttribute(XType xthis, XType xtype, out bool isCustom)
        {
            return XCheckXTypeAttribute(xtype, xthis.XGetCustomAttributes(), out isCustom);
        }

        public static string XToTitle(XType xtype)
        {
            return XToTitle(xtype.XGetCustomAttributes());
        }

        public static List<XType> XFromQuery(IQueryCollection query, X x)
        {
            List<XType> xtypes = new List<XType>();
            foreach (KeyValuePair<string, StringValues> pair in query)
            {
                foreach (string value in pair.Value)
                {
                    string dll = value.Split(".")[0];
                    xtypes.Add(x.XGetType(value + "," + dll));
                }
            }
            return xtypes;
        }

        public static void XToAccessKeyMap(Dictionary<string, List<XFieldInfo>> xfields, Dictionary<string, List<XPropertyInfo>> xprops, out Dictionary<string, char> accessKeyMap, out List<char> accessKeys)
        {
            List<string> names = new List<string>();
            foreach (List<XFieldInfo> xfieldList in xfields.Values)
            {
                foreach(XFieldInfo xfield in xfieldList)
                {
                    names.Add(xfield.XName);
                }
            }
            foreach (List<XPropertyInfo> xpropList in xprops.Values)
            {
                foreach(XPropertyInfo xprop in xpropList)
                {
                    names.Add(xprop.XName);
                }
            }
            XToAccessKeyMap(names.ToArray(), out accessKeyMap, out accessKeys);
        }
    }
}
