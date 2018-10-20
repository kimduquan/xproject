using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem.XInternal
{
    public class XObjectInternal : XObject
    {
        private object obj;
        private XType xtype;

        public XObjectInternal(object o, XType t)
        {
            obj = o;
            xtype = t;
        }

        public object X => obj;

        public bool XEquals(XObject other)
        {
            return X.Equals(other.X);
        }

        public int XGetHashCode()
        {
            return X.GetHashCode();
        }

        public XType XGetType()
        {
            return xtype;
        }

        public string XToString()
        {
            return X.ToString();
        }
    }
}
