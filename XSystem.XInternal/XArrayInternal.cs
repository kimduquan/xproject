using System;

namespace XSystem.XInternal
{
    public class XArrayInternal : XObjectInternal, XArray
    {
        private Array array = null;
        private X x;

        public XArrayInternal(Array a, X x) : base(a, x)
        {
            array = a;
            this.x = x;
        }

        public int XLength => array.Length;

        public int XGetLength(int dimension)
        {
            return array.GetLength(dimension);
        }

        public XObject XGetValue(int index)
        {
            return x.XNew(array.GetValue(index));
        }
    }
}
