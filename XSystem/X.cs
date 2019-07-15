using System;
using System.Reflection;
using XSystem.XReflection;

namespace XSystem
{
    public abstract class X
    {
        public abstract XObject XNew(object obj);
        public abstract XType XTypeOf(Type type);
        public abstract XObject XNULL { get; }
        public abstract XType XGetType(string name);
        public delegate XAssembly XNewAssembly(Assembly assembly, X x);
        public XNewAssembly XAssembly = null;
        public abstract XAttribute XAttribute(Attribute attr);
        public abstract XException XCatch(Exception ex);
    }
}
