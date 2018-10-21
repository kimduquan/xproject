using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;

namespace XSystem.XReflection.XInternal
{
    class XFieldInfoInternal : XFieldInfo
    {
        private FieldInfo field = null;
        private XType xfieldType = null;

        public XType XFieldType => xfieldType;

        public string XName => field.Name;

        public bool XIsStatic => field.IsStatic;

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
