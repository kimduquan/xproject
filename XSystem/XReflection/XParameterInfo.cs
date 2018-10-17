using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem.XReflection
{
    public interface XParameterInfo
    {
        string XName { get; }
        XType XParameterType { get; }
        bool XHasDefaultValue { get; }
        object XDefaultValue { get; }
        bool XIsOptional { get; }
    }
}
