using System.Reflection;

namespace XSystem.XReflection.XInternal
{
    public class XMemberInfoInternal : XMemberInfo
    {
        private MemberInfo member;

        public XMemberInfoInternal(MemberInfo m)
        {
            member = m;
        }
    }
}
