using System;

namespace _XSystem
{
    [AttributeUsage(AttributeTargets.All, Inherited = true)]
    public class _XString : Attribute
    {
        public _XString(string s)
        {
            XString = s;
        }

        public string XString { get; }
    }
}
