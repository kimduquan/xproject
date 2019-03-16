using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem.XInternal
{
    public class XAttributeInternal : XAttribute
    {
        private Attribute attribute = null;
        private X x = null;

        public XAttributeInternal(Attribute attr, X xx)
        {
            attribute = attr;
            x = xx;
        }

        public XType XGetType()
        {
            return x.XTypeOf(attribute.GetType());
        }
    }
}
