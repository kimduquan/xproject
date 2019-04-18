﻿using System.Collections.Generic;
using System.Reflection;

namespace XSystem.XReflection.XInternal
{
    public class XFieldInfoInternal : Internal, XFieldInfo
    {
        private FieldInfo field = null;
        private XType xfieldType = null;
        private XType xdeclaringType = null;

        public XType XFieldType => xfieldType;
        public string XName => field.Name;
        public bool XIsStatic => field.IsStatic;

        public XType XDeclaringType
        {
            get
            {
                if(xdeclaringType == null)
                {
                    xdeclaringType = X().XTypeOf(field.DeclaringType);
                }
                return xdeclaringType;
            }
        }

        public bool XIsInitOnly => field.IsInitOnly;

        public XFieldInfoInternal(FieldInfo f, X x): base(x)
        {
            field = f;
        }

        public XObject XGetValue(XObject target)
        {
            return X().XNew(field.GetValue(target));
        }

        public void XSetValue(XObject target, XObject value)
        {
            field.SetValue(target.X, value.X);
        }

        public bool Equals(XFieldInfo other)
        {
            XFieldInfoInternal otherField = other as XFieldInfoInternal;
            return field.Equals(otherField.field);
        }

        public int XGetHashCode()
        {
            return field.GetHashCode();
        }

        public XObject[] XGetCustomAttributes(XType xtype, bool inherit)
        {
            List<XObject> result = new List<XObject>();
            foreach (object obj in field.GetCustomAttributes(xtype.X, inherit))
            {
                result.Add(X().XNew(obj));
            }
            return result.ToArray();
        }
    }
}
