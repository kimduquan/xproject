using System.Reflection;

namespace XSystem.XReflection.XInternal
{
    public class XMemberInfoInternal : Internal, XMemberInfo
    {
        private MemberInfo member;
        private XType xdeclaringType = null;
        private XType xreflectedType = null;

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

        public XType XReflectedType
        {
            get
            {
                if (xreflectedType == null)
                {
                    xreflectedType = X().XTypeOf(member.ReflectedType);
                }
                return xreflectedType;
            }
        }

        public XMemberTypes XMemberType => (XMemberTypes)member.MemberType;
    }
}
