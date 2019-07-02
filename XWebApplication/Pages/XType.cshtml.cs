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
using XWebApplication.Models.XSystem;
using XWebApplication.Util;

namespace XWebApplication.Pages
{
    [Authorize( Policy = "Type" )]
    public class XTypeModel : PageModel
    {
        private XType xtype = null;
        private IMemoryCache cache = null;
        private _XThisCache xthis = null;

        public XTypeModel(IMemoryCache memory, X xx, XTypeConverter converter)
        {
            cache = memory;
            X = xx;
            XConverter = converter;
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
                    xtype = _XTypeModel.XFromRoute(RouteData, X);
                }
                return xtype;
            }
        }

        public XTypeConverter XConverter { get; }

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
            foreach(XFieldInfo xfield in XType.XGetFields())
            {
                if(xfield.XIsStatic)
                {
                    if(Request.Form.ContainsKey(xfield.XName))
                    {
                        StringValues values = Request.Form[xfield.XName];
                        if (XConverter.XCanConvertTo(xfield.XFieldType))
                        {
                            XObject xvalue = XConverter.XConvertTo(values.ToString(), xfield.XFieldType);
                            xfield.XSetValue(null, xvalue);
                        }
                    }
                }
            }
        }
    }
}