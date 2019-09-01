using System;
using System.Collections.Generic;
using System.Text;

namespace XCS
{
    public class XRemoteOutput : XOutput
    {
        public XRemoteOutput(XInput xinput, XOutput xoutput)
        {

        }
        public XInput XInput { get; protected set; }
        public XOutput XOutput { get; protected set; }

        public override string XToString()
        {
            throw new NotImplementedException();
        }

        public override bool XWriteStrings(List<string> strings)
        {
            bool bRes = XOutput.XWriteStrings(strings);
            return bRes;
        }
    }
}
