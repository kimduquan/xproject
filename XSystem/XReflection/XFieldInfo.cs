using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem.XReflection
{
    public interface XFieldInfo
    {
        XObject XGetValue(XObject target);
        void XSetValue(XObject target, XObject value);
        XType XFieldType { get; }
        string XName { get; }
        bool XIsStatic { get; }
    }
}
