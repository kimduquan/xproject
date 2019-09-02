using System;
using System.Collections.Generic;

namespace XCS
{
    public class XStdOutput : XOutput
    {
        public override bool XClose()
        {
            return true;
        }

        public override bool XWriteStrings(List<string> strings)
        {
            Console.WriteLine(string.Join(' ', strings));
            return strings.Count > 0;
        }
    }
}
