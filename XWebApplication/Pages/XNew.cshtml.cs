using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Reflection;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Caching.Memory;
using Microsoft.Extensions.Primitives;
using XSystem;
using XSystem.XComponentModel;
using XSystem.XComponentModel.XInternal;
using XSystem.XInternal;
using XSystem.XReflection;
using xsystem = XSystem.XInternal.XInternal;

namespace XWebApplication.Pages
{
    public class XNewModel : PageModel
    {
        private IMemoryCache cache = null;
        private X x = null;
        private XConstructorInfo xconstructor = null;
        private XType xtype = null;
        private List<XType> xparameterTypes = null;
        private List<XObject> xparameterValues = null;
        private XTypeConverter xconverter = null;

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

        public XConstructorInfo XConstructor
        {
            get
            {
                if(xconstructor == null)
                {
                    xconstructor = XType.XGetConstructor(XParamterTypes);
                }
                return xconstructor;
            }
        }

        public XType XType
        {
            get
            {
                if(xtype == null)
                {
                    string ns = (string)RouteData.Values["namespace"];
                    ns = ns.Replace('-', '.');
                    string t = (string)RouteData.Values["type"];
                    xtype = X.XTypeOf(Type.GetType(ns + "." + t));
                }
                return xtype;
            }
        }

        protected XType[] XParamterTypes
        {
            get
            {
                if(xparameterTypes == null)
                {
                    xparameterTypes = new List<XType>();
                    foreach (KeyValuePair<string, StringValues> pair in Request.Query)
                    {
                        foreach (string value in pair.Value)
                        {
                            xparameterTypes.Add(X.XTypeOf(Type.GetType(value)));
                        }
                    }
                }
                return xparameterTypes.ToArray();
            }
        }

        protected XObject[] XParameterValues
        {
            get
            {
                if(xparameterValues == null)
                {
                    XParameterInfo[] xparameters = XConstructor.XGetParameters();
                    xparameterValues = new List<XObject>();
                    if(XConverter.XCanConvertFrom(typeof(string)))
                    {
                        foreach (XParameterInfo xparameter in XConstructor.XGetParameters())
                        {
                            StringValues value = Request.Form[xparameter.XName];
                            if (XConverter.XCanConvertTo(xparameter.XParameterType))
                            {
                                xparameterValues.Add(XConverter.XConvertTo(value.ToString(), xparameter.XParameterType));
                            }
                        }
                    }
                }
                return xparameterValues.ToArray();
            }
        }

        protected XTypeConverter XConverter
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

        public XNewModel(IMemoryCache c)
        {
            cache = c;
        }

        public void OnGet()
        {
            object x = XConstructor;
        }

        public void OnPost()
        {
            XObject xobject = XConstructor.XInvoke(XParameterValues);
            string key = xobject.XGetType().XFullName + "@" + xobject.XGetHashCode();
            cache.Set<XObject>(key, xobject);
        }
    }
}