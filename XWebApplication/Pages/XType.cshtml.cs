using System.Collections.Generic;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Caching.Memory;
using Microsoft.Extensions.Primitives;
using XSystem;
using XSystem.XComponentModel;
using XSystem.XReflection;
using XWebApplication.Models;
using XWebApplication.Util;

namespace XWebApplication.Pages
{
    [Authorize( Policy = "Type" )]
    public class XTypeModel : PageModel
    {
        private XType xtype = null;
        private XFieldInfo[] xstaticFields = null;
        private XMethodInfo[] xstaticMethods = null;
        private XFieldInfo[] xarrayFields = null;
        private IMemoryCache cache = null;
        private _XThisCache xthis = null;
        private Dictionary<string, XObject> xobjects = null;

        public XTypeModel(IMemoryCache memory, X xx, XTypeConverter converter)
        {
            cache = memory;
            X = xx;
            XConverter = converter;
        }

        public Dictionary<string, XObject> XObjects
        {
            get
            {
                if (xobjects == null)
                {
                    XUtil.XGetCache(cache, HttpContext.Session, out xobjects);
                }
                return xobjects;
            }
        }

        public _XThisCache XThis
        {
            get
            {
                if(xthis == null)
                {
                    xthis = _XThisModel.XFromCache(cache, HttpContext.Session);
                }
                return xthis;
            }
        }

        public X X { get; }

        public XType XType
        {
            get
            {
                if (xtype == null)
                {
                    XUtil.XFromRoute(out xtype, RouteData);
                }
                return xtype;
            }
        }

        public XTypeConverter XConverter { get; }

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
                    xarrayFields = fields.ToArray();
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

        public XJSONConverter XJsonConverter { get; } = null;

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

        public JsonResult OnGetArray()
        {
            string field = Request.Query["field"];
            XFieldInfo xfield = XType.XGetField(field);
            XObject xvalue = xfield.XGetValue(null);
            return XJsonConverter.XConvertToJSON(xvalue, xfield.XFieldType);
        }
    }
}