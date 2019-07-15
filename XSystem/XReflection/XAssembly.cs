using System.Collections.Generic;

namespace XSystem.XReflection
{
    public interface XAssembly
    {
        XType XGetType(string name);
        IEnumerable<XType> XExportedTypes { get; }
        string XFullName { get; }
        IEnumerable<XAttribute> XGetCustomAttributes();
        XMethodInfo XEntryPoint { get; }
    }
}
