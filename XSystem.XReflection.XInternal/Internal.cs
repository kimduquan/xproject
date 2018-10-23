using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem.XReflection.XInternal
{
    public abstract class Internal
    {
        private X x;

        public Internal(X x)
        {
            this.x = x;
        }

        public X X()
        {
            return x;
        }
    }
}
