using _XSystem;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Localization;
using Microsoft.Extensions.Primitives;
using System.Collections.Generic;
using XSystem;
using XSystem.XComponentModel;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem.XReflection
{
    public class _XMethodInfoModel
    {
        public XParameterInfo[] XParameters { get; set; }
        public List<char> XAccessKeys { get; set; }

        public static void XToAccessKeyMap(XParameterInfo[] xparams, out Dictionary<string, char> accessKeyMap, out List<char> accessKeys)
        {
            List<string> names = new List<string>();
            foreach (XParameterInfo xparam in xparams)
            {
                names.Add(xparam.XName);
            }
            _XModel.XToAccessKeyMap(names.ToArray(), out accessKeyMap, out accessKeys);
        }

        public static string XToHref(XType xtype, XMethodInfo method)
        {
            return _XTypeModel.XToHref(xtype) + "/" + method.XName;
        }

        public static XObject[] XFromForm(X x, XParameterInfo[] xparams, XTypeConverter xtypeConverter, IFormCollection form, _XThisCache cache)
        {
            List<XObject>  values = new List<XObject>();
            if (xtypeConverter.XCanConvertFrom(typeof(string)))
            {
                XType _this = x.XTypeOf(typeof(_XThis));
                foreach (XParameterInfo xparameter in xparams)
                {
                    StringValues value = form[xparameter.XName];
                    XObject xobject = null;
                    if (xtypeConverter.XCanConvertTo(xparameter.XParameterType))
                    {
                        xobject = xtypeConverter.XConvertTo(value.ToString(), xparameter.XParameterType);
                    }
                    else if (cache != null)
                    {
                        if (xparameter.XParameterType.XIsAssignableFrom(cache.XThis.XGetType()))
                        {
                            XObject[] xattrs = xparameter.XGetCustomAttributes(_this, true);
                            if (xattrs != null && xattrs.Length > 0)
                            {
                                xobject = cache.XThis;
                            }
                        } 

                        if(xobject == null)
                        {
                            if (value.ToString() == "")
                            {
                                xobject = x.XNULL;
                            }
                            else
                            {
                                xobject = _XObjectModel.XFromCache(cache, value.ToString());
                            }
                        }
                    }
                    values.Add(xobject);
                }
            }
            return values.ToArray();
        }
    }
}
