namespace XSystem.XReflection
{
    public interface XMethodInfo : XMemberInfo
    {
        XParameterInfo[] XGetParameters();
        XObject XInvoke(XObject target, XObject[] parameters);
        
        bool XIsStatic { get; }
        XType XReturnType { get; }
    }
}
