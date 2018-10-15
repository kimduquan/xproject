using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem.XReflection
{
    public interface XPropertyInfo
    {
        XObject XGetValue(XObject target);
        void XSetValue(XObject target, XObject value);
        XMethodInfo XGetGetMethod();
        XMethodInfo XGetSetMethod();
    }
}
