using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;

namespace XSystem.XReflection.XInternal
{
    public class XParameterInfoInternal : XParameterInfo
    {
        private ParameterInfo parameter;
        private XType xparameterType;

        public XParameterInfoInternal(ParameterInfo p)
        {
            parameter = p;
            xparameterType = null;
        }

        public string XName { get => parameter.Name; }

        public XType XParameterType => xparameterType;

        public bool XHasDefaultValue => parameter.HasDefaultValue;

        public object XDefaultValue => parameter.DefaultValue;

        public bool XIsOptional => parameter.IsOptional;
    }
}
