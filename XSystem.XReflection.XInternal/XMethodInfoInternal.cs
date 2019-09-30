using System.Collections.Generic;
using System.Reflection;

namespace XSystem.XReflection.XInternal
{
    public class XMethodInfoInternal : XMemberInfoInternal, XMethodInfo
    {
        private MethodInfo method = null;
        private List<XParameterInfo> xparameters = null;
        private XType xreturnType = null;

        public XMethodInfoInternal(MethodInfo m, X x) : base(m, x)
        {
            method = m;
        }

        public bool XIsStatic => method.IsStatic;

        public XType XReturnType
        {
            get
            {
                if(xreturnType == null)
                {
                    if(method.ReturnType != null)
                    {
                        xreturnType = X().XTypeOf(method.ReturnType);
                    }
                }
                return xreturnType;
            }
        }

        public XParameterInfo[] XGetParameters()
        {
            if(xparameters == null)
            {
                xparameters = new List<XParameterInfo>();
                foreach(ParameterInfo paramter in method.GetParameters())
                {
                    xparameters.Add(new XParameterInfoInternal(this, paramter, X()));
                }
            }
            return xparameters.ToArray();
        }

        public XObject XInvoke(XObject target, XObject[] parameters)
        {
            List<object> objects = new List<object>();
            foreach (XObject xobject in parameters)
            {
                objects.Add(xobject.X);
            }
            return X().XNew(method.Invoke(target.X, objects.ToArray()));
        }
    }
}
