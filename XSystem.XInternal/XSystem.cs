using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem.XInternal
{
    public class XSystem
    {
        public static XType XTypeOf(string name)
        {
            return XTypeInternal.XGetType(name);
        }

        public static XType XTypeOf(Type t)
        {
            return new XTypeInternal(t);
        }

        public static XObject XNew(object obj, XType xtype)
        {
            return new XObjectInternal(obj, xtype);
        }
    }
}
