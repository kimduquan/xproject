namespace XSystem.XReflection
{
    public interface XConstructorInfo
    {
        XParameterInfo[] XGetParameters();
        XObject XInvoke(XObject[] parameters);
        XObject[] XGetCustomAttributes();
    }
}
