using System;
using System.Collections.Generic;
using System.Reflection;

namespace XSystem.XReflection.XInternal
{
    public class XPropertyInfoInternal : XMemberInfoInternal, XPropertyInfo
    {
        private PropertyInfo property = null;
        private XType xpropertyType = null;

        public XType XPropertyType
        {
            get
            {
                if(xpropertyType == null)
                {
                    xpropertyType = X().XTypeOf(property.PropertyType);
                }
                return xpropertyType;
            }
        }

        public bool XIsStatic
        {
            get
            {
                if (property.GetMethod != null)
                    return property.GetMethod.IsStatic;
                else
                    return property.SetMethod.IsStatic;
            }
        }

        public bool XCanWrite => property.CanWrite;

        public bool XCanRead => property.CanRead;

        public XPropertyInfoInternal(PropertyInfo p, X x) : base(p, x)
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

        public int XGetHashCode()
        {
            return property.GetHashCode();
        }

        public XObject[] XGetCustomAttributes(XType xtype, bool inherit)
        {
            List<XObject> result = new List<XObject>();
            foreach (object obj in property.GetCustomAttributes(xtype.X, inherit))
            {
                result.Add(X().XNew(obj));
            }
            return result.ToArray();
        }
    }
}
