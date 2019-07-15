using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Threading.Tasks;
using XSystem;
using XSystem.XReflection;
using XWebApplication.Models;
using XWebApplication.Models.XSystem;

namespace XWebApplication.ViewComponents
{
    public class _XTypeViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(XType xtype, _XThisCache xthis)
        {
            _XTypeModel xmodel = new _XTypeModel(xtype, xthis);
            xmodel.XConstructors = xtype.XGetConstructors();

            xmodel.XFields = new Dictionary<string, List<XFieldInfo>>();
            xmodel.XFieldTypes = new List<XType>();
            foreach(XFieldInfo xfield in xtype.XGetFields())
            {
                if(xfield.XIsStatic)
                {
                    XType xfieldType = xfield.XDeclaringType;
                    string fieldKey = xfieldType.XFullName;
                    if (xmodel.XFields.ContainsKey(fieldKey))
                    {
                        xmodel.XFields[fieldKey].Add(xfield);
                    }
                    else
                    {
                        xmodel.XFieldTypes.Add(xfieldType);
                        List<XFieldInfo> xfields = new List<XFieldInfo>();
                        xfields.Add(xfield);
                        xmodel.XFields.Add(fieldKey, xfields);
                    }
                }
            }

            xmodel.XProperties = new Dictionary<string, List<XPropertyInfo>>();
            xmodel.XPropertyTypes = new List<XType>();
            foreach (XPropertyInfo xprop in xtype.XGetProperties())
            {
                if(xprop.XIsStatic)
                {
                    XType xpropType = xprop.XDeclaringType;
                    string propKey = xpropType.XFullName;
                    if(xmodel.XProperties.ContainsKey(propKey))
                    {
                        xmodel.XProperties[propKey].Add(xprop);
                    }
                    else
                    {
                        xmodel.XPropertyTypes.Add(xpropType);
                        List<XPropertyInfo> xprops = new List<XPropertyInfo>();
                        xprops.Add(xprop);
                        xmodel.XProperties.Add(propKey, xprops);
                    }
                }
            }

            List<XMethodInfo> xmethods = new List<XMethodInfo>();
            foreach (XMethodInfo xmethod in xtype.XGetMethods())
            {
                if(xmethod.XIsStatic)
                {
                    xmethods.Add(xmethod);
                }
            }
            xmodel.XMethods = xmethods.ToArray();

            Dictionary<string, char> accessKeyMap = new Dictionary<string, char>();
            List<char> accessKeys = new List<char>();
            _XTypeModel.XToAccessKeyMap(xmodel.XFields, xmodel.XProperties, out accessKeyMap, out accessKeys);
            xmodel.XAccessKeys = accessKeyMap;

            return View(xmodel);
        }
    }
}
