namespace XSystem.XReflection
{
    public interface XPropertyInfo
    {
        XObject XGetValue(XObject target);
        void XSetValue(XObject target, XObject value);
        XMethodInfo XGetGetMethod();
        XMethodInfo XGetSetMethod();
        XType XPropertyType { get; }
        string XName { get; }
        int XGetHashCode();
        XType XDeclaringType { get; }
        bool XIsStatic { get; }
        bool XCanWrite { get; }
        bool XCanRead { get; }

        XObject[] XGetCustomAttributes(XType attributeType, bool inherit);
    }
}
