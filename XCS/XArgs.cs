using System.Collections.Generic;

namespace XCS
{
    public class XArgs : XInput
    {
        private List<string> xargs = new List<string>();

        public XArgs(string[] args) : base()
        {
            xargs.AddRange(args);
        }

        public override bool XClose()
        {
            return true;
        }

        public override bool XReadStrings(out List<string> strings)
        {
            strings = new List<string>();
            strings.AddRange(xargs);
            return xargs.Count > 0;
        }
    }
}
