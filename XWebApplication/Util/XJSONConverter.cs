using Microsoft.AspNetCore.Mvc;
using XSystem;

namespace XWebApplication.Util
{
    public interface XJSONConverter
    {
        JsonResult XConvertToJSON(XObject xobject, XType xtype);
    }
}
