using System;
using System.Collections.Generic;
using System.IO;
using System.IO.Pipes;
using System.Text;
using XCS;

namespace cs
{
    class RemotePipeOutput : XOutput
    {
        public RemotePipeOutput(string str)
        {
            Stream = new AnonymousPipeClientStream(PipeDirection.Out, str);
            Writer = new StreamWriter(Stream);
        }

        protected AnonymousPipeClientStream Stream { get; set; }
        protected StreamWriter Writer { get; set; }
        public override bool XClose()
        {
            Writer.Close();
            Stream.Close();
            return true;
        }

        public override bool XWriteStrings(List<string> strings)
        {
            string data = string.Join(Convert.ToChar(0), strings);
            Writer.Write(data);
            Stream.WaitForPipeDrain();
            return true;
        }
    }
}
