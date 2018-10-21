using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;

namespace XSystem.XReflection.XInternal
{
    public class XPropertyInfoInternal : XPropertyInfo
    {
        private PropertyInfo property = null;
        private XType xpropertyType = null;

        public XType XPropertyType => xpropertyType;

        public string XName => property.Name;

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
            throw new NotImplementedException();
        }

        public void XSetValue(XObject target, XObject value)
        {
            throw new NotImplementedException();
        }
    }
}
