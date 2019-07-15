using System;

namespace XSystem
{
    [AttributeUsage(AttributeTargets.Field | AttributeTargets.Parameter | AttributeTargets.Property | AttributeTargets.ReturnValue)]
    public class XNull : Attribute
    {
    }
}
