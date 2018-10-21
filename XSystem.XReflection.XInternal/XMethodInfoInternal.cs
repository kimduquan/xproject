using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;

namespace XSystem.XReflection.XInternal
{
    public class XMethodInfoInternal : XMethodInfo
    {
        private MethodInfo method = null;
        private XParameterInfo[] xparameters = null;

        public XMethodInfoInternal()
        {
            
        }

        public string XName => method.Name;

        public bool XIsStatic => method.IsStatic;

        public XParameterInfo[] XGetParameters()
        {
            return xparameters;
        }

        public XObject XInvoke(XObject target, XObject[] parameters)
        {
            throw new NotImplementedException();
        }
    }
}
