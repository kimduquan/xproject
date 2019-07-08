using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Caching.Memory;
using XSystem;
using XSystem.XComponentModel;
using XSystem.XReflection;
using XWebApplication.Models;
using XWebApplication.Models.XSystem;
using XWebApplication.Models.XSystem.XReflection;
using XWebApplication.Util;

namespace XWebApplication.Pages
{
    [Authorize(Policy = "new")]
    public class XNewModel : PageModel
    {
        private IMemoryCache cache = null;
        private XConstructorInfo xconstructor = null;
        private XType xtype = null;
        private List<XType> xparameterTypes = null;
        private _XThisCache xthis = null;
        private X x = null;
        private string title = null;
        private XTypeConverter xtypeConverter = null;

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
                    xtype = _XTypeModel.XFromRoute(RouteData, x);
                }
                return xtype;
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

        protected XType[] XParamterTypes
        {
            get
            {
                if(xparameterTypes == null)
                {
                    xparameterTypes = _XTypeModel.XFromQuery(Request.Query, x);
                }
                return xparameterTypes.ToArray();
            }
        }

        public string XTitle
        {
            get
            {
                if(title == null)
                {
                    string type = _XTypeModel.XToString(XType);
                    string assembly = _XAssemblyModel.XToString(XType.XAssembly);
                    title = string.Format("{0} - New {1}", assembly, type);
                }
                return title;
            }
        }

        public XException XException { get; set; }

        public XNewModel(IMemoryCache c, X xx, XTypeConverter converter)
        {
            cache = c;
            x = xx;
            xtypeConverter = converter;
        }

        public void OnGet()
        {
            object x = XConstructor;
        }

        public async Task<IActionResult> OnPost()
        {
            XObject[] xparams = _XMethodInfoModel.XFromForm(XConstructor.XGetParameters(), xtypeConverter, Request.Form, XThis);
            try
            {
                XObject xobject = XConstructor.XInvoke(xparams);
                if (xobject != x.XNULL)
                {
                    _XThisCache.XToCache(XThis, xobject);
                    string url = _XObjectModel.XToHref(xobject);
                    return LocalRedirect(url);
                }
            }
            catch(Exception ex)
            {
                XException = x.XCatch(ex);
            }
            return Page();
        }
    }
}