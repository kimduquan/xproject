namespace XSystem.XReflection
{
    public interface XMemberInfo
    {
        string XName { get; }
        XType XDeclaringType { get; }
        XType XReflectedType { get; }
        XMemberTypes XMemberType { get; }
    }
}
