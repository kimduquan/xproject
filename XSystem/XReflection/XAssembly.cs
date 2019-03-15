using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem.XReflection
{
    public interface XAssembly
    {
        XType XGetType(string name);
        IEnumerable<XType> XExportedTypes { get; }
        String XFullName { get; }
    }
}
