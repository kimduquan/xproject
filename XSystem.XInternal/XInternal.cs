using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;
using XSystem.XReflection;

namespace XSystem.XInternal
{
    public class XInternal : X
    {
        private static XNull xnull;

        public override XObject XNULL
        {
            get
            {
                if(xnull == null)
                {
                    xnull = new XNull();
                }
                return xnull;
            }
        }

        public XInternal()
        {
            xnull = new XNull();
        }

        public override XObject XNew(object obj)
        {
            if (obj == null)
                return xnull;
            return new XObjectInternal(obj, this);
        }

        public override XType XTypeOf(Type type)
        {
            if(type == null)
            {
                return null;
            }
            return new XTypeInternal(type, this);
        }

        public override XType XGetType(string name)
        {
            Type type = Type.GetType(name);
            if (type == null)
            {
                return null;
            }
            return new XTypeInternal(type, this);
        }

        public override XAttribute XAttribute(Attribute attr)
        {
            return new XAttributeInternal(attr, this);
        }

        class XNull : XObject
        {
            public object X => null;

            public bool Equals(XObject other)
            {
                if (other.X == null)
                    return true;
                return false;
            }

            public bool XEqual(XObject xobject)
            {
                return X == xobject.X;
            }

            public int XGetHashCode()
            {
                return 0;
            }

            public XType XGetType()
            {
                return null;
            }

            public string XToString()
            {
                return "null";
            }
        }
    }
}
