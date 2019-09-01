using System.Collections.Generic;

namespace XCS
{
    public class XRemoteInput : XInput
    {
        public XRemoteInput(XInput xinput, XOutput xoutput) : base()
        {
            XInput = xinput;
            XOutput = xoutput;
        }
        public XInput XInput { get; protected set; }
        public XOutput XOutput { get; protected set; }
        public override bool XReadStrings(out List<string> strings)
        {
            bool bRes = XInput.XReadStrings(out strings);
            if(bRes)
            {
                bRes = XOutput.XWriteStrings(strings);
            }
            return bRes;
        }

        public override string XToString()
        {
            string res = XOutput.XToString();
            return res;
        }
    }
}
