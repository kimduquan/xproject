using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;

namespace XSystem.XReflection.XInternal
{
    public class XAssemblyInternal : XAssembly
    {
        private Assembly assembly = null;

        private XAssemblyInternal()
        {

        }

        public XType XGetType(string name)
        {
            throw new NotImplementedException();
        }

        public static XAssembly XNew(Assembly assembly)
        {
            XAssemblyInternal xassembly = new XAssemblyInternal();
            xassembly.assembly = assembly;
            return xassembly;
        }
    }
}
