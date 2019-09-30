namespace XSystem.XReflection
{
    public interface XConstructorInfo : XMemberInfo
    {
        XParameterInfo[] XGetParameters();
        XObject XInvoke(XObject[] parameters);
        XObject[] XGetCustomAttributes();
    }
}
