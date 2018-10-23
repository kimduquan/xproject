using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem
{
    public abstract class X
    {
        public abstract XObject XNew(object obj);
        public abstract XType XTypeOf(Type type);
        public abstract XObject XNULL { get; }
    }
}
