using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Threading.Tasks;
using XSystem;
using XSystem.XReflection;
using XWebApplication.Models;
using XWebApplication.Models.XSystem.XReflection;
using XWebApplication.Util;

namespace XWebApplication.ViewComponents
{
    public class _XInViewComponent : ViewComponent
    {
        private X x = null;
        public _XInViewComponent(X xx)
        {
            x = xx;
        }

        public async Task<IViewComponentResult> InvokeAsync(object model, char accessKey, int tabIndex, _XThisCache xthis)
        {
            if(model is XParameterInfo xparam)
            {
                return await xparameter(xparam, accessKey, tabIndex, xthis);
            }
            else if (model is XFieldInfo xfield)
            {
                return await xfieldInfo(xfield, accessKey, tabIndex, xthis);
            }
            else if (model is XPropertyInfo xprop)
            {
                return await xpropertyInfo(xprop, accessKey, tabIndex, xthis);
            }
            return View();
        }

        protected async Task<IViewComponentResult> xparameter(XParameterInfo xparameter, char accessKey, int tabIndex, _XThisCache xthis)
        {
            _XInModel xmodel = new _XInModel();
            xmodel.AccessKey = accessKey;
            xmodel.Class = "in " + _XParameterInfoModel.XToClass(xparameter);
            xmodel.Data = _XParameterInfoModel.XToData(xparameter);
            xmodel.Name = xparameter.XName;
            xmodel.TabIndex = tabIndex;
            xmodel.Text = _XParameterInfoModel.XToString(xparameter);
            xmodel.XType = xparameter.XParameterType;
            bool ximplicit = _XParameterInfoModel.XIsImplicit(xparameter, x);
            string view = null;
            XBuild(xmodel, out view, xthis, ximplicit);
            if(view != null)
            {
                return View(view, xmodel);
            }
            return View(xmodel);
        }

        protected async Task<IViewComponentResult> xfieldInfo(XFieldInfo xfield, char accessKey, int tabIndex, _XThisCache xthis)
        {
            _XInModel xmodel = new _XInModel();
            xmodel.AccessKey = accessKey;
            xmodel.Name = xfield.XName;
            xmodel.TabIndex = tabIndex;
            xmodel.Text = _XFieldInfoModel.XToString(xfield);
            xmodel.XType = xfield.XFieldType;
            bool ximplicit = _XFieldInfoModel.XIsImplicit(xfield, x);
            string view = null;
            XBuild(xmodel, out view, xthis, ximplicit);
            if (view != null)
            {
                return View(view, xmodel);
            }
            return View(xmodel);
        }

        protected async Task<IViewComponentResult> xpropertyInfo(XPropertyInfo xproperty, char accessKey, int tabIndex, _XThisCache xthis)
        {
            _XInModel xmodel = new _XInModel();
            xmodel.AccessKey = accessKey;
            xmodel.Name = xproperty.XName;
            xmodel.TabIndex = tabIndex;
            xmodel.Text = _XPropertyInfoModel.XToString(xproperty);
            xmodel.XType = xproperty.XPropertyType;
            bool ximplicit = _XPropertyInfoModel.XIsImplicit(xproperty, x);
            string view = null;
            XBuild(xmodel, out view, xthis, ximplicit);
            if (view != null)
            {
                return View(view, xmodel);
            }
            return View(xmodel);
        }

        protected void XBuild(_XInModel xmodel, out string view, _XThisCache xthis, bool ximplicit)
        {
            xmodel.DefaultValue = "";
            xmodel.Disabled = "";
            xmodel.Id = "";
            xmodel.ReadOnly = "";
            xmodel.Required = "";
            xmodel.SpellCheck = "";
            xmodel.AccessKeyIndex = xmodel.Text.IndexOf(xmodel.AccessKey, StringComparison.OrdinalIgnoreCase);
            xmodel.Type = "";
            view = null;
            if (xmodel.XType.XIsEnum)
            {
                view = "Enum";
            }
            else if (xmodel.XType.XFullName == (typeof(string[])).FullName)
            {
                view = "StringArray";
            }
            else if (xmodel.XType.XIsArray)
            {
                view = "Array";
            }
            else
            {
                view = "Default";
                if (ximplicit)
                {
                    xmodel.Type = "password";
                }
                else if (xmodel.XType.XFullName == (typeof(bool)).FullName)
                {
                    xmodel.Type = "checkbox";
                }
                else if (xmodel.XType.XFullName == (typeof(Color)).FullName)
                {
                    xmodel.Type = "color";
                }
                else if (xmodel.XType.XFullName == (typeof(DateTime)).FullName)
                {
                    xmodel.Type = "datetime";
                }
                else if (xmodel.XType.XFullName == (typeof(File)).FullName)
                {
                    xmodel.Type = "file";
                }
                else if (xmodel.XType.XFullName == (typeof(float)).FullName)
                {
                    xmodel.Type = "number";
                }
                else if (xmodel.XType.XFullName == (typeof(int)).FullName)
                {
                    xmodel.Type = "number";
                }
                else if (xmodel.XType.XFullName == (typeof(string)).FullName)
                {
                    xmodel.SpellCheck = "spellcheck";
                    xmodel.Type = "text";
                }
                else if (xmodel.XType.XFullName == (typeof(Uri)).FullName)
                {
                    xmodel.Type = "url";
                }
                else
                {
                    view = "Ref";
                    xmodel.XObjects = new Dictionary<string, XObject>();
                    foreach (var keyValue in xthis.XObjects)
                    {
                        XType xtype2 = keyValue.Value.XGetType();
                        if (xmodel.XType.XIsAssignableFrom(xtype2))
                        {
                            xmodel.XObjects.Add(keyValue.Key, keyValue.Value);
                        }
                    }
                }
            }
        }
    }
}
