using System;
using System.Collections.Generic;
using System.Reflection;

namespace XSystem.XReflection.XInternal
{
    public class XAssemblyInternal : Internal, XAssembly
    {
        private Assembly assembly = null;
        private List<XType> exportedTypes = null;
        private List<XAttribute> xcustomAttributes = null;
        private XMethodInfo xentryPoint = null;

        public string XFullName => assembly.FullName;

        protected XAssemblyInternal(Assembly a, X x) : base(x)
        {
            assembly = a;
        }

        public XType XGetType(string name)
        {
            Type t = assembly.GetType(name);
            if (t == null)
                return null;
            return X().XTypeOf(t);
        }

        public IEnumerable<XType> XExportedTypes
        {
            get
            {
                if(exportedTypes == null)
                {
                    exportedTypes = new List<XType>();
                    IEnumerable<Type> types = assembly.ExportedTypes;
                    IEnumerator<Type> it = types.GetEnumerator();
                    while (it.MoveNext())
                    {
                        XType type = X().XTypeOf(it.Current);
                        exportedTypes.Add(type);
                    }
                }
                return exportedTypes;
            }
        }

        public XMethodInfo XEntryPoint
        {
            get
            {
                if(xentryPoint == null)
                {
                    if(assembly.EntryPoint != null)
                        xentryPoint = new XMethodInfoInternal(assembly.EntryPoint, X());
                }
                return xentryPoint;
            }
        }

        public static XAssembly XNew(Assembly assembly, X x)
        {
            return new XAssemblyInternal(assembly, x);
        }

        public IEnumerable<XAttribute> XGetCustomAttributes()
        {
            if(xcustomAttributes == null)
            {
                xcustomAttributes = new List<XAttribute>();
                foreach (Attribute attr in assembly.GetCustomAttributes())
                {
                    xcustomAttributes.Add(X().XAttribute(attr));
                }
            }
            return xcustomAttributes;
        }
    }
}
