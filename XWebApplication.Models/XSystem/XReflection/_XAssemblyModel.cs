using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Routing;
using Microsoft.Extensions.Localization;
using Microsoft.Extensions.Primitives;
using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem.XReflection
{
    public class _XAssemblyModel
    {
        public Dictionary<string, List<string>> XNamespaces { get; set; }
        public Dictionary<string, List<XType>> XTypes { get; set; }
        public Dictionary<string, string> XInformation { get; set; }
        public IStringLocalizer XString { get; set; }

        public static XType XGetEntryType(XAssembly xassembly)
        {
            XType xtype = null;
            foreach (XType t in xassembly.XExportedTypes)
            {
                if (t.XName == t.XNamespace && t.XName == t.XAssembly.XFullName.Split(',')[0])
                {
                    xtype = t;
                    break;
                }
            }
            return xtype;
        }

        public static XAssembly XFromRoute(RouteData route, X x)
        {
            XAssembly xassembly = null;
            string dll = (string)route.Values["assembly"];
            dll = dll.Replace('-', '.');
            XType xtype = x.XGetType(dll + "." + dll + "," + dll);
            if(xtype != null)
            {
                xassembly = xtype.XAssembly;
            }
            return xassembly;
        }

        public static XAssembly XFromReturnUrl(IQueryCollection query, X x)
        {
            XAssembly xassembly = null;
            XType xtype = null;
            StringValues returnUrl;
            query.TryGetValue("ReturnUrl", out returnUrl);
            string url = returnUrl.ToString();
            if (url.EndsWith("/"))
            {
                url = url.TrimEnd('/');
            }
            if (url.StartsWith("/"))
            {
                url = url.TrimStart('/');
            }
            string[] path = url.Split("/");
            if (path.Length > 0)
            {
                string dll = path[0].Replace('-', '.');
                xtype = x.XGetType(dll + "." + dll + "," + dll);
                if(xtype != null)
                {
                    xassembly = xtype.XAssembly;
                }
            }
            return xassembly;
        }

        public static Dictionary<string, string> XToAbout(XAssembly assemly, IStringLocalizer xstring)
        {
            Dictionary<string, string>  about = new Dictionary<string, string>();
            foreach (XAttribute xattr in assemly.XGetCustomAttributes())
            {
                if (xattr.XGetType().XName.StartsWith("Assembly") && xattr.XGetType().XName.EndsWith("Attribute") && xattr.XGetType().XNamespace == "System.Reflection")
                {
                    string attr = xattr.XGetType().XName;
                    attr = attr.Substring("Assembly".Length);
                    attr = attr.Substring(0, attr.Length - "Attribute".Length);
                    XPropertyInfo xprop = xattr.XGetType().XGetProperty(attr);
                    if (xprop != null && xprop.XIsStatic == false)
                    {
                        string v = _XStringModel.XToString(xprop.XGetValue(xattr), xstring);
                        about[attr] = v;
                    }
                }
            }
            return about;
        }
    }
}
