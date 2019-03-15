using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;
using XSystem.XReflection;

namespace XSystem
{
    public abstract class X
    {
        public abstract XObject XNew(object obj);
        public abstract XType XTypeOf(Type type);
        public abstract XObject XNULL { get; }
        public abstract XType XGetType(String name);
        public delegate XAssembly XNewAssembly(Assembly assembly, X x);
        public XNewAssembly XAssembly = null;
    }
}
