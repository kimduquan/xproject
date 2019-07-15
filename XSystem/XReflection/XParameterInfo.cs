namespace XSystem.XReflection
{
    public interface XParameterInfo
    {
        string XName { get; }
        XType XParameterType { get; }
        bool XHasDefaultValue { get; }
        XObject XDefaultValue { get; }
        bool XIsOptional { get; }
        bool XIsIn { get; }
        bool XIsOut { get; }
        bool XIsRetval { get; }
        int XPosition { get; }

        XObject[] XGetCustomAttributes(XType attributeType, bool inherit);
    }
}
