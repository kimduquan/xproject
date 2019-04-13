using System.Collections.Generic;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Caching.Memory;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Pages
{
    [Authorize]
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
                    XUtil.XFromRoute(out xtype, RouteData);
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
                    XUtil.XFromQuery(out xparameterTypes, Request.Query);
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
                    XUtil.XFromForm(out xparameterValues, xparameters, Request.Form);
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
            XUtil.XToCache(xobject, cache, HttpContext.Session);
        }
    }
}