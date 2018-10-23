using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;
using XSystem.XReflection;

namespace XSystem.XReflection.XInternal
{
    public class XConstructorInfoInternal : Internal, XConstructorInfo
    {
        private ConstructorInfo constructor;
        private List<XParameterInfo> xparameters = null;

        public XConstructorInfoInternal(ConstructorInfo c, X x) : base(x)
        {
            constructor = c;
        }

        public XParameterInfo[] XGetParameters()
        {
            if(xparameters == null)
            {
                xparameters = new List<XParameterInfo>();
                foreach (ParameterInfo parameter in constructor.GetParameters())
                {
                    xparameters.Add(new XParameterInfoInternal(parameter, X()));
                }
            }
            return xparameters.ToArray();
        }

        public XObject XInvoke(XObject[] parameters)
        {
            List<object> objects = new List<object>();
            foreach (XObject xobject in parameters)
            {
                objects.Add(xobject);
            }
            return X().XNew(constructor.Invoke(objects.ToArray()));
        }
    }
}
