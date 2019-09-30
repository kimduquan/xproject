namespace XSystem.XReflection
{
    public interface XMemberInfo
    {
        string XName { get; }
        XType XDeclaringType { get; }
        XMemberTypes XMemberType { get; }
    }
}
