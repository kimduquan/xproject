using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Primitives;
using System.Collections.Generic;
using System.Security.Claims;
using XSystem;
using XSystem.XReflection;
using XWebApplication.Util;

namespace XWebApplication.Models.XSystem
{
    public class _XTypeModel : _XModel
    {
        private XMethodInfo[] xstaticMethods = null;
        private XFieldInfo[] xstaticFields = null;
        private XPropertyInfo[] xstaticProperties = null;
        private Dictionary<string, char> xaccessKeys = null;

        public _XTypeModel(XType type, _XThisCache xthis): base(xthis)
        {
            XType = type;
        }

        public XConstructorInfo[] XConstructors
        {
            get
            {
                return XType.XGetConstructors();
            }
        }

        public XMethodInfo[] XMethods
        {
            get
            {
                if(xstaticMethods == null)
                {
                    List<XMethodInfo> list = new List<XMethodInfo>();
                    foreach(XMethodInfo xmethod in XType.XGetMethods())
                    {
                        if(xmethod.XIsStatic)
                        {
                            list.Add(xmethod);
                        }
                    }
                    xstaticMethods = list.ToArray();
                }
                return xstaticMethods;
            }
        }

        public XType XType { get; }

        protected XFieldInfo[] XStaticFields
        {
            get
            {
                if(xstaticFields == null)
                {
                    List<XFieldInfo> list = new List<XFieldInfo>();
                    foreach (XFieldInfo xfield in XType.XGetFields())
                    {
                        if (xfield.XIsStatic)
                        {
                            list.Add(xfield);
                        }
                    }
                    xstaticFields = list.ToArray();
                }
                return xstaticFields;
            }
        }

        protected XPropertyInfo[] XStaticProperties
        {
            get
            {
                if(xstaticProperties == null)
                {
                    List<XPropertyInfo> list = new List<XPropertyInfo>();
                    foreach(XPropertyInfo xprop in XType.XGetProperties())
                    {
                        if(xprop.XIsStatic)
                        {
                            list.Add(xprop);
                        }
                    }
                    xstaticProperties = list.ToArray();
                }
                return xstaticProperties;
            }
        }

        protected Dictionary<string, char> XAccessKeys
        {
            get
            {
                if(xaccessKeys == null)
                {
                    xaccessKeys = new Dictionary<string, char>();
                    Dictionary<char, string> key = new Dictionary<char, string>();
                    foreach (XFieldInfo field in XStaticFields)
                    {
                        foreach (char ch in field.XName)
                        {
                            if (char.IsLetterOrDigit(ch))
                            {
                                char temp = char.ToLower(ch);
                                if (!key.ContainsKey(temp))
                                {
                                    key[temp] = field.XName;
                                    xaccessKeys[field.XName] = temp;
                                    break;
                                }
                            }
                        }
                    }
                    foreach (XPropertyInfo prop in XStaticProperties)
                    {
                        foreach (char ch in prop.XName)
                        {
                            if (char.IsLetterOrDigit(ch))
                            {
                                char temp = char.ToLower(ch);
                                if (!key.ContainsKey(temp))
                                {
                                    key[temp] = prop.XName;
                                    xaccessKeys[prop.XName] = temp;
                                    break;
                                }
                            }
                        }
                    }
                }
                return xaccessKeys;
            }
        }

        public void XGetFields(out Dictionary<string, List<XFieldInfo>> xfieldMap, out List<XType> xfieldTypes)
        {
            xfieldMap = new Dictionary<string, List<XFieldInfo>>();
            xfieldTypes = new List<XType>();
            foreach (XFieldInfo xfield in XStaticFields)
            {
                if (xfieldMap.ContainsKey(xfield.XDeclaringType.XFullName) == false)
                {
                    xfieldTypes.Add(xfield.XDeclaringType);
                    List<XFieldInfo> list = new List<XFieldInfo>();
                    list.Add(xfield);
                    xfieldMap[xfield.XDeclaringType.XFullName] = list;
                }
                else
                {
                    xfieldMap[xfield.XDeclaringType.XFullName].Add(xfield);
                }
            }
        }

        public void XGetProperties(out Dictionary<string, List<XPropertyInfo>> xpropMap, out List<XType> xpropTypes)
        {
            xpropTypes = new List<XType>();
            xpropMap = new Dictionary<string, List<XPropertyInfo>>();
            foreach (XPropertyInfo xprop in XStaticProperties)
            {
                if (xpropMap.ContainsKey(xprop.XDeclaringType.XFullName) == false)
                {
                    xpropTypes.Add(xprop.XDeclaringType);
                    List<XPropertyInfo> list = new List<XPropertyInfo>();
                    list.Add(xprop);
                    xpropMap[xprop.XDeclaringType.XFullName] = list;
                }
                else
                {
                    xpropMap[xprop.XDeclaringType.XFullName].Add(xprop);
                }
            }
        }

        public char XGetAccessKey(string name)
        {
            return XAccessKeys[name];
        }

        public static string XToString(XType xtype)
        {
            return XToString(xtype.XName);
        }

        public static string XToHref(XType xtype)
        {
            return "";
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

        public static XType XFromClaims(ClaimsPrincipal user, X x)
        {
            XType xtype = null;
            if (user.HasClaim(c => c.Type == "Type"))
            {
                Claim t = user.FindFirst(c => c.Type == "Type");
                xtype = XFromFullName(t.Value, x);
            }
            return xtype;
        }

        protected static XType XFromFullName(string fullName, X x)
        {
            XType xtype = x.XGetType(fullName + "," + fullName.Split('.')[0]);
            return xtype;
        }
        
        public static string XToCssClass(XType xtype)
        {
            return xtype.XName.ToLower().Replace('_', '-');
        }
    }
}
