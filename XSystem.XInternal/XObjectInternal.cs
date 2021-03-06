﻿namespace XSystem.XInternal
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

        public bool Equals(XObject other)
        {
            return X.Equals(other.X);
        }

        public bool XEqual(XObject xobject)
        {
            return X.Equals(xobject.X);
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
