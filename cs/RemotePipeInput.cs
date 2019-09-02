using System;
using System.Collections.Generic;
using System.IO;
using System.IO.Pipes;
using XCS;

namespace cs
{
    public class RemotePipeInput : XInput
    {
        public RemotePipeInput(string str)
        {
            Stream = new AnonymousPipeClientStream(PipeDirection.In, str);
            Reader = new StreamReader(Stream);
        }

        protected AnonymousPipeClientStream Stream { get; set; }
        protected StreamReader Reader { get; set; }
        public override bool XClose()
        {
            Reader.Close();
            Stream.Close();
            return true;
        }

        public override bool XReadStrings(out List<string> strings)
        {
            Stream.WaitForPipeDrain();
            string data = Reader.ReadToEnd();
            strings = new List<string>(data.Split(Convert.ToChar(0)));
            return true;
        }
    }
}
