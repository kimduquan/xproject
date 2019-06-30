using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Threading.Tasks;
using XSystem;
using XSystem.XReflection;
using XWebApplication.Models.XSystem;
using XWebApplication.Util;

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

            xmodel.XAccessKeys = new Dictionary<string, char>();
            Dictionary<char, string> key = new Dictionary<char, string>();
            foreach (XFieldInfo field in xmodel.XFields.Values)
            {
                foreach (char ch in field.XName)
                {
                    if (char.IsLetterOrDigit(ch))
                    {
                        char temp = char.ToLower(ch);
                        if (!key.ContainsKey(temp))
                        {
                            key[temp] = field.XName;
                            xmodel.XAccessKeys.Add(field.XName, temp);
                            break;
                        }
                    }
                }
            }
            foreach (XPropertyInfo prop in xmodel.XProperties.Values)
            {
                foreach (char ch in prop.XName)
                {
                    if (char.IsLetterOrDigit(ch))
                    {
                        char temp = char.ToLower(ch);
                        if (!key.ContainsKey(temp))
                        {
                            key[temp] = prop.XName;
                            xmodel.XAccessKeys.Add(prop.XName, temp);
                            break;
                        }
                    }
                }
            }

            return View(xmodel);
        }
    }
}
