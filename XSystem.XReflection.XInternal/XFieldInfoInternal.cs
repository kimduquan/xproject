using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;

namespace XSystem.XReflection.XInternal
{
    public class XFieldInfoInternal : Internal, XFieldInfo
    {
        private FieldInfo field = null;
        private XType xfieldType = null;

        public XType XFieldType => xfieldType;
        public string XName => field.Name;
        public bool XIsStatic => field.IsStatic;

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
    }
}
