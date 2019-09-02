using System;
using System.Collections.Generic;

namespace XCS
{
    public class XStdInput : XInput
    {
        public override bool XClose()
        {
            return true;
        }

        public override bool XReadStrings(out List<string> strings)
        {
            strings = new List<string>();
            strings.AddRange(Console.ReadLine().Split(' '));
            return strings.Count > 0;
        }
    }
}
