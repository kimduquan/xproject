using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem
{
    public interface XObject : IEquatable<XObject>
    {
        int XGetHashCode();
        string XToString();
        XType XGetType();

        object X { get; }
    }
}
