﻿using System;

namespace XSystem.XReflection
{
    public interface XFieldInfo : IEquatable<XFieldInfo>
    {
        XObject XGetValue(XObject target);
        void XSetValue(XObject target, XObject value);
        XType XFieldType { get; }
        string XName { get; }
        bool XIsStatic { get; }
        int XGetHashCode();
        XType XDeclaringType { get; }
        bool XIsInitOnly { get; }

        XObject[] XGetCustomAttributes(XType attributeType, bool inherit);
    }
}
