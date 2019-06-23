using Microsoft.AspNetCore.Mvc;
using System;
using System.Drawing;
using System.IO;
using System.Threading.Tasks;
using XSystem.XReflection;
using XWebApplication.Models;
using XWebApplication.Models.XSystem.XReflection;

namespace XWebApplication.ViewComponents
{
    public class _XInViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(XParameterInfo xparameter, char accessKey, int tabIndex)
        {
            _XInModel xmodel = new _XInModel();
            xmodel.AccessKey = accessKey;
            xmodel.Class = "in " + _XParameterInfoModel.XToClass(xparameter);
            xmodel.Data = _XParameterInfoModel.XToData(xparameter);
            xmodel.DefaultValue = "";
            xmodel.Disabled = "";
            xmodel.Id = "";
            xmodel.Name = xparameter.XName;
            xmodel.ReadOnly = "";
            xmodel.Required = "";
            xmodel.SpellCheck = "";
            xmodel.TabIndex = tabIndex;
            xmodel.Text = _XParameterInfoModel.XToString(xparameter);
            xmodel.AccessKeyIndex = xmodel.Text.IndexOf(accessKey, StringComparison.OrdinalIgnoreCase);
            xmodel.Type = "";
            xmodel.XType = xparameter.XParameterType;
            string view = null;
            if (xmodel.XType.XIsEnum)
            {
                view = "Enum";
            }
            else if(xmodel.XType.XFullName == (typeof(string[])).FullName)
            {
                view = "StringArray";
            }
            else if(xmodel.XType.XIsArray)
            {
                view = "Array";
            }
            else
            {
                view = "Default";
                if (_XParameterInfoModel.XIsImplicit(xparameter))
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
                }
            }
            if(view != null)
            {
                return View(view, xmodel);
            }
            return View(xmodel);
        }
    }
}
