using System;

namespace _XSystem
{
    [AttributeUsage( AttributeTargets.All, AllowMultiple = true, Inherited = true)]
    public class _XType : Attribute
    {
        public _XType(Type t)
        {
            XType = t;
        }

        public Type XType { get; } = null;
    }
}
