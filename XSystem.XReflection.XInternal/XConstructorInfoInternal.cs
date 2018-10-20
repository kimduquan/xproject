using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;
using XSystem.XReflection;

namespace XSystem.XReflection.XInternal
{
    public class XConstructorInfoInternal : XConstructorInfo
    {
        private ConstructorInfo constructor;
        private XParameterInfo[] xparameters;

        public XConstructorInfoInternal(ConstructorInfo c)
        {
            constructor = c;
            xparameters = null;
        }

        public XParameterInfo[] XGetParameters()
        {
            if(xparameters == null)
            {
                ParameterInfo[] parameters = constructor.GetParameters();
                if(parameters != null)
                {
                    xparameters = new XParameterInfo[parameters.Length];
                    int index = 0;
                    foreach (ParameterInfo parameter in parameters)
                    {
                        xparameters[index] = new XParameterInfoInternal(parameter);
                        index++;
                    }
                }
            }
            return xparameters;
        }

        public XObject XInvoke(XObject[] parameters)
        {
            throw new NotImplementedException();
        }
    }
}
