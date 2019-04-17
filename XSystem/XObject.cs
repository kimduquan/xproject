using System;

namespace XSystem
{
    public interface XObject : IEquatable<XObject>
    {
        int XGetHashCode();
        string XToString();
        XType XGetType();
        bool XEqual(XObject xobject);

        object X { get; }
    }
}
