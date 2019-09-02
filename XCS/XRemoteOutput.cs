using System;
using System.Collections.Generic;
using System.Text;

namespace XCS
{
    public class XRemoteOutput : XOutput
    {
        public XRemoteOutput(XOutput xoutput, XInput xinput)
        {

        }
        public XInput XInput { get; protected set; }
        public XOutput XOutput { get; protected set; }

        public override bool XClose()
        {
            return true;
        }

        public override bool XWriteStrings(List<string> strings)
        {
            bool bRes = XInput.XReadStrings(out strings);
            if(bRes)
            {
                bRes = XOutput.XWriteStrings(strings);
            }
            return bRes;
        }
    }
}
