using System.Collections.Generic;
using System.Reflection;

namespace XSystem.XReflection.XInternal
{
    public class XParameterInfoInternal : Internal, XParameterInfo
    {
        private ParameterInfo parameter;
        private XType xparameterType = null;
        private XMemberInfo xmember;

        public XParameterInfoInternal(XMemberInfo member, ParameterInfo p, X x) : base(x)
        {
            parameter = p;
            xmember = member;
        }

        public string XName { get => parameter.Name; }

        public XType XParameterType
        {
            get
            {
                if (xparameterType == null)
                {
                    xparameterType = X().XTypeOf(parameter.ParameterType);
                }
                return xparameterType;
            }
    }

        public bool XHasDefaultValue => parameter.HasDefaultValue;

        public XObject XDefaultValue { get { return X().XNew(parameter.DefaultValue); } }

        public bool XIsOptional => parameter.IsOptional;

        public bool XIsIn => parameter.IsIn;

        public bool XIsOut => parameter.IsOut;

        public bool XIsRetval => parameter.IsRetval;

        public int XPosition => parameter.Position;

        public XMemberInfo XMember => xmember;

        public XObject[] XGetCustomAttributes(XType xtype, bool inherit)
        {
            List<XObject> result = new List<XObject>();
            foreach(object obj in parameter.GetCustomAttributes(xtype.X, inherit))
            {
                result.Add(X().XNew(obj));
            }
            return result.ToArray();
        }
    }
}
