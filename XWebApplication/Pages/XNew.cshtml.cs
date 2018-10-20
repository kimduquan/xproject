using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Reflection;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Primitives;
using XSystem;
using XSystem.XComponentModel;
using XSystem.XComponentModel.XInternal;
using XSystem.XInternal;
using XSystem.XReflection;
using xsystem = XSystem.XInternal.XSystem;

namespace XWebApplication.Pages
{
    public class XNewModel : PageModel
    {
        private XConstructorInfo xconstructor = null;
        private XType xtype = null;
        private XType[] xparameterTypes = null;
        private XObject[] xparameterValues = null;
        private XTypeConverter xconverter = null;

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
                    string cls = (string)RouteData.Values["class"];
                    xtype = XTypeInternal.XGetType(ns + "." + cls);
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
                    xparameterTypes = new XType[Request.Query.Count];
                    int index = 0;
                    foreach (KeyValuePair<string, StringValues> pair in Request.Query)
                    {
                        foreach (string value in pair.Value)
                        {
                            xparameterTypes[index] = XTypeInternal.XGetType(value);
                            index++;
                        }
                    }
                }
                return xparameterTypes;
            }
        }

        protected XObject[] XParameterValues
        {
            get
            {
                if(xparameterValues == null)
                {
                    XParameterInfo[] xparameters = XConstructor.XGetParameters();
                    xparameterValues = new XObject[xparameters.Length];
                    if(XConverter.XCanConvertFrom(typeof(string)))
                    {
                        int index = 0;
                        foreach (XParameterInfo xparameter in xparameters)
                        {
                            StringValues value = Request.Form[xparameter.XName];
                            if (XConverter.XCanConvertTo(xparameter.XParameterType))
                            {
                                xparameterValues[index] = XConverter.XConvertTo(value.ToString(), xparameter.XParameterType);
                            }
                            index++;
                        }
                    }
                }
                return xparameterValues;
            }
        }

        protected XTypeConverter XConverter
        {
            get
            {
                if(xconverter == null)
                {
                    xconverter = new XObjectConverterInternal();
                }
                return xconverter;
            }
        }

        public void OnGet()
        {
            object x = XConstructor;
        }

        public void OnPost()
        {
            XConstructor.XInvoke(XParameterValues);
        }
    }
}