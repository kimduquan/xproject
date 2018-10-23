using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using XSystem;

namespace XWebApplication
{
    public interface XJSONConverter
    {
        JsonResult XConvertToJSON(XObject xobject, XType xtype);
    }
}
