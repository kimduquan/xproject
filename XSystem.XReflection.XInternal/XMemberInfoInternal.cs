using System.Reflection;

namespace XSystem.XReflection.XInternal
{
    public class XMemberInfoInternal : Internal, XMemberInfo
    {
        private MemberInfo member;
        private XType xdeclaringType = null;

        public XMemberInfoInternal(MemberInfo m, X x) : base(x)
        {
            member = m;
        }

        public string XName => member.Name;

        public XType XDeclaringType
        {
            get
            {
                if (xdeclaringType == null)
                {
                    xdeclaringType = X().XTypeOf(member.DeclaringType);
                }
                return xdeclaringType;
            }
        }

        public XMemberTypes XMemberType => (XMemberTypes)member.MemberType;
    }
}
