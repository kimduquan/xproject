using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem.XReflection
{
    public class _XAssemblyModel
    {
        public static string XToString(XAssembly assembly)
        {
            return _XModel.XToString(assembly.XFullName.Split(',')[0]);
        }

        public static XType XGetEntryType(XAssembly xassembly)
        {
            XType xtype = null;
            foreach (XType t in xassembly.XExportedTypes)
            {
                if (t.XName == t.XNamespace && t.XName == t.XAssembly.XFullName.Split(',')[0])
                {
                    xtype = t;
                    break;
                }
            }
            return xtype;
        }
    }
}
