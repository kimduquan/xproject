using System.Collections.Generic;
using System.Reflection;

namespace XSystem.XReflection.XInternal
{
    public class XConstructorInfoInternal : Internal, XConstructorInfo
    {
        private ConstructorInfo constructor = null;
        private List<XParameterInfo> xparameters = null;
        private XObject[] xcustomAttributes = null;

        public XConstructorInfoInternal(ConstructorInfo c, X x) : base(x)
        {
            constructor = c;
        }

        public XObject[] XGetCustomAttributes()
        {
            if (xcustomAttributes == null)
            {
                List<XObject> xobjects = new List<XObject>();
                foreach (object obj in constructor.GetCustomAttributes())
                {
                    xobjects.Add(X().XNew(obj));
                }
                xcustomAttributes = xobjects.ToArray();
            }
            return xcustomAttributes;
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
