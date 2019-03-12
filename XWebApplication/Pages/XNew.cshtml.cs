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
        private XConstructorInfo xconstructor = null;
        private XType xtype = null;
        private List<XType> xparameterTypes = null;
        private List<XObject> xparameterValues = null;

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
                    Util.XFromRoute(out xtype, RouteData);
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
                    Util.XFromQuery(out xparameterTypes, Request.Query);
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
                    Util.XFromForm(out xparameterValues, xparameters, Request.Form);
                }
                return xparameterValues.ToArray();
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
            Util.XToCache(xobject, cache);
        }
    }
}