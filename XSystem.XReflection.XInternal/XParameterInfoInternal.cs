﻿using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;

namespace XSystem.XReflection.XInternal
{
    public class XParameterInfoInternal : Internal, XParameterInfo
    {
        private ParameterInfo parameter;
        private XType xparameterType = null;

        public XParameterInfoInternal(ParameterInfo p, X x) : base(x)
        {
            parameter = p;
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
        
    }
}
