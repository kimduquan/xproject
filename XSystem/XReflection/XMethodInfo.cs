namespace XSystem.XReflection
{
    public interface XMethodInfo
    {
        XParameterInfo[] XGetParameters();
        XObject XInvoke(XObject target, XObject[] parameters);
        string XName { get; }
        bool XIsStatic { get; }
        XType XReturnType { get; }
        XType XDeclaringType { get; }
    }
}
