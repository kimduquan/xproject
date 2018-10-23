using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;

namespace XSystem.XReflection.XInternal
{
    public class XMethodInfoInternal : Internal, XMethodInfo
    {
        private MethodInfo method = null;
        private List<XParameterInfo> xparameters = null;

        public XMethodInfoInternal(MethodInfo m, X x) : base(x)
        {
            method = m;
        }

        public string XName => method.Name;
        public bool XIsStatic => method.IsStatic;

        public XParameterInfo[] XGetParameters()
        {
            if(xparameters == null)
            {
                xparameters = new List<XParameterInfo>();
                foreach(ParameterInfo paramter in method.GetParameters())
                {
                    xparameters.Add(new XParameterInfoInternal(paramter, X()));
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
