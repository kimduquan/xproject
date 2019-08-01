using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;
using XWebApplication.Models.XSystem;

namespace XWebApplication.Models
{
    public class _XParamsModel
    {
        public static string XToKey(XType xtype, XMethodInfo xmethod, XParameterInfo xparam)
        {
            return xtype.XFullName + "/" + xmethod.XName + "/" + xparam.XName;
        }

        public static string XToKey(XType xtype, XConstructorInfo xconstructor, XParameterInfo xparam)
        {
            return xtype.XFullName + "/" + xtype.XName + "/" + xparam.XName;
        }

        public static bool XFromCache(_XThisCache xthis, string key, out List<XObject> xobjects, int? start, int? count)
        {
            bool res = false;
            xobjects = null;
            if(xthis.XParams.ContainsKey(key))
            {
                res = xthis.XParams.TryGetValue(key, out xobjects);
                if(res)
                {
                    xobjects = xobjects.GetRange(start.GetValueOrDefault(0), count.GetValueOrDefault(xobjects.Count));
                }
            }
            return res;
        }

        public static bool XToCache(_XThisCache xthis, string key, string objKey)
        {
            bool res = false;
            XObject xobject = _XObjectModel.XFromCache(xthis, objKey);
            if(xobject != null)
            {
                if(xthis.XParams.ContainsKey(key))
                {
                    List<XObject> xparams = null;
                    res = xthis.XParams.TryGetValue(key, out xparams);
                    if(res)
                    {
                        xparams.Add(xobject);
                    }
                }
            }
            return res;
        }
    }
}
