using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;

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
