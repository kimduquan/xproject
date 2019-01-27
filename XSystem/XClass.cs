using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem
{
    [AttributeUsage(AttributeTargets.Class | AttributeTargets.Constructor | AttributeTargets.Field | AttributeTargets.Method | AttributeTargets.Property)]
    public class XClass : Attribute
    {
        private Type type;

        public XClass(Type t)
        {
            type = t;
        }
    }
}
