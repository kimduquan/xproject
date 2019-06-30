﻿using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem.XReflection
{
    public class _XAssemblyModel
    {
        public Dictionary<string, List<string>> XNamespaces { get; set; }
        public Dictionary<string, List<XType>> XTypes { get; set; }
        public Dictionary<string, string> XInformation { get; set; }

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

        public static Dictionary<string, string> XToAbout(XAssembly assemly)
        {
            Dictionary<string, string>  about = new Dictionary<string, string>();
            foreach (XAttribute xattr in assemly.XGetCustomAttributes())
            {
                if (xattr.XGetType().XName.StartsWith("Assembly") && xattr.XGetType().XName.EndsWith("Attribute") && xattr.XGetType().XNamespace == "System.Reflection")
                {
                    string attr = xattr.XGetType().XName;
                    attr = attr.Substring("Assembly".Length);
                    attr = attr.Substring(0, attr.Length - "Attribute".Length);
                    XPropertyInfo xprop = xattr.XGetType().XGetProperty(attr);
                    if (xprop != null && xprop.XIsStatic == false)
                    {
                        about[attr] = xprop.XGetValue(xattr).XToString();
                    }
                }
            }
            return about;
        }
    }
}
