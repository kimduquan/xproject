using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem.XInternal
{
    public class XObjectInternal : XObject
    {
        private object obj;
        private X x;
        private XType xtype;

        public XObjectInternal(object o, X x)
        {
            obj = o;
            xtype = null;
            this.x = x;
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
            if(xtype == null)
            {
                xtype = x.XTypeOf(obj.GetType());
            }
            return xtype;
        }

        public string XToString()
        {
            return X.ToString();
        }
    }
}
