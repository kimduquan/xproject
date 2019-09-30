using System.Collections.Generic;
using System.Reflection;

namespace XSystem.XReflection.XInternal
{
    public class XFieldInfoInternal : XMemberInfoInternal, XFieldInfo
    {
        private FieldInfo field = null;
        private XType xfieldType = null;

        public XType XFieldType => xfieldType;
        public bool XIsStatic => field.IsStatic;

        public bool XIsInitOnly => field.IsInitOnly;

        public XFieldInfoInternal(FieldInfo f, X x): base(f, x)
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
