using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem
{
    public interface XObject
    {
        bool XEquals(XObject other);
        int XGetHashCode();
        string XToString();
        XType XGetType();
    }
}
