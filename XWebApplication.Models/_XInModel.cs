using Microsoft.Extensions.Localization;
using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models
{
    public class _XInModel
    {
        public string Class { get; set; }
        public string Name { get; set; }
        public string Data { get; set; }
        public string Text { get; set; }
        public char AccessKey { get; set; }
        public XType XType { get; set; }
        public string Id { get; set; }
        public int TabIndex { get; set; }
        public string Disabled { get; set; }
        public string ReadOnly { get; set; }
        public string DefaultValue { get; set; }
        public string Required { get; set; }
        public string SpellCheck { get; set; }
        public string Type { get; set; }
        public int AccessKeyIndex { get; set; }
        public Dictionary<string, List<XFieldInfo>> XFields { get; set; }
        public Dictionary<string, List<XPropertyInfo>> XProperties { get; set; }
        public Dictionary<string, XObject> XObjects { get; set; }
        public IStringLocalizer XString { get; set; }
    }
}
