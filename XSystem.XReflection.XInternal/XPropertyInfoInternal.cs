﻿using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;

namespace XSystem.XReflection.XInternal
{
    public class XPropertyInfoInternal : Internal, XPropertyInfo
    {
        private PropertyInfo property = null;
        private XType xpropertyType = null;

        public XType XPropertyType => xpropertyType;

        public string XName => property.Name;

        public XPropertyInfoInternal(PropertyInfo p, X x) : base(x)
        {
            property = p;
        }

        public XMethodInfo XGetGetMethod()
        {
            throw new NotImplementedException();
        }

        public XMethodInfo XGetSetMethod()
        {
            throw new NotImplementedException();
        }

        public XObject XGetValue(XObject target)
        {
            return X().XNew(property.GetValue(target.X));
        }

        public void XSetValue(XObject target, XObject value)
        {
            property.SetValue(target.X, value.X);
        }
    }
}