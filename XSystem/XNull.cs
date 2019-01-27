using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem
{
    [AttributeUsage(AttributeTargets.Field | AttributeTargets.Parameter | AttributeTargets.Property | AttributeTargets.ReturnValue)]
    public class XNull : Attribute
    {
    }
}
