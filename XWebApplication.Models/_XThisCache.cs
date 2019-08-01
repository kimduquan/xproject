using Microsoft.Extensions.Localization;
using System.Collections.Generic;
using XSystem;
using XWebApplication.Models.XSystem;

namespace XWebApplication.Models
{
    public class _XThisCache
    {
        public XObject XThis { get; }
        public Dictionary<string, XObject> XObjects { get; }
        public Dictionary<string, List<XObject>> XParams { get; }
        public IStringLocalizer XString { get; set; }

        public _XThisCache(XObject xthis)
        {
            XThis = xthis;
            XObjects = new Dictionary<string, XObject>();
            XObjects.Add(_XObjectModel.XToKey(xthis), xthis);
            XParams = new Dictionary<string, List<XObject>>();
        }
    }
}
