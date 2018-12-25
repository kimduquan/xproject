using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Primitives;
using XSystem;
using XSystem.XComponentModel;
using XSystem.XComponentModel.XInternal;
using XSystem.XInternal;
using XSystem.XReflection;

namespace XWebApplication.Pages
{
    public class XTypeModel : PageModel
    {
        private X x = null;
        private XType xtype = null;
        private XTypeConverter xconverter = null;
        private XFieldInfo[] xstaticFields = null;
        private XMethodInfo[] xstaticMethods = null;
        private XFieldInfo[] xarrayFields = null;
        private XJSONConverter xjsonConverter = null;

        public X X
        {
            get
            {
                if(x == null)
                {
                    x = new XInternal();
                }
                return x;
            }
        }

        public XType XType
        {
            get
            {
                if (xtype == null)
                {
                    string ns = (string)RouteData.Values["namespace"];
                    ns = ns.Replace('-', '.');
                    string t = (string)RouteData.Values["type"];
                    xtype = X.XTypeOf(Type.GetType(ns + "." + t));
                }
                return xtype;
            }
        }

        public XTypeConverter XConverter
        {
            get
            {
                if(xconverter == null)
                {
                    xconverter = new XObjectConverterInternal(X);
                }
                return xconverter;
            }
        }

        public XFieldInfo[] XStaticFields
        {
            get
            {
                if(xstaticFields == null)
                {
                    List<XFieldInfo> fields = new List<XFieldInfo>();
                    foreach(XFieldInfo xfield in XType.XGetFields())
                    {
                        if(xfield.XIsStatic && !xfield.XFieldType.XIsArray)
                        {
                            fields.Add(xfield);
                        }
                    }
                    xstaticFields = fields.ToArray();
                }
                return xstaticFields;
            }
        }

        public XMethodInfo[] XStaticMethods
        {
            get
            {
                if(xstaticMethods == null)
                {
                    List<XMethodInfo> methods = new List<XMethodInfo>();
                    foreach(XMethodInfo xmethod in XType.XGetMethods())
                    {
                        if(xmethod.XIsStatic)
                        {
                            methods.Add(xmethod);
                        }
                    }
                    xstaticMethods = methods.ToArray();
                }
                return xstaticMethods;
            }
        }

        public XFieldInfo[] XArrayFields
        {
            get
            {
                if(xarrayFields == null)
                {
                    List<XFieldInfo> fields = new List<XFieldInfo>();
                    foreach (XFieldInfo xfield in XType.XGetFields())
                    {
                        if (xfield.XIsStatic && xfield.XFieldType.XIsArray)
                        {
                            fields.Add(xfield);
                        }
                    }
                    xstaticFields = fields.ToArray();
                }
                return xarrayFields;
            }
        }

        public string XGetValue(XFieldInfo xfield)
        {
            XObject value = xfield.XGetValue(null);
            return XConverter.XConvertToString(value);
        }

        public string XGetValue(XPropertyInfo xproperty)
        {
            XObject value = xproperty.XGetValue(null);
            return XConverter.XConvertToString(value);
        }

        public XJSONConverter XJsonConverter
        {
            get
            {
                return xjsonConverter;
            }
        }

        public void OnGet()
        {
            object x = XType;
        }

        public void OnPost()
        {
            foreach(XFieldInfo xfield in XStaticFields)
            {
                StringValues values = Request.Form[xfield.XName];
                if(XConverter.XCanConvertTo(xfield.XFieldType))
                {
                    XObject xvalue = XConverter.XConvertTo(values.ToString(), xfield.XFieldType);
                    xfield.XSetValue(null, xvalue);
                }
            }
        }

        public string XGetHref(XMethodInfo xmethod)
        {
            string ns = XType.XNamespace;
            ns = ns.Replace('.', '-');
            string type = XType.XName;
            string href = string.Format("/{0}/{1}/{2}", ns, type, xmethod.XName);
            return href;
        }

        public JsonResult OnGetArray()
        {
            string field = Request.Query["field"];
            XFieldInfo xfield = XType.XGetField(field);
            XObject xvalue = xfield.XGetValue(null);
            return XJsonConverter.XConvertToJSON(xvalue, xfield.XFieldType);
        }
    }
}