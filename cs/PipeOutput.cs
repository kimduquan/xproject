using System;
using System.Collections.Generic;
using System.IO;
using System.IO.Pipes;
using XCS;

namespace cs
{
    public class PipeOutput : XOutput
    {
        public AnonymousPipeServerStream Stream { get; protected set; }
        protected StreamWriter Writer { get; set; }

        public PipeOutput(out string input)
        {
            Stream = new AnonymousPipeServerStream(PipeDirection.Out, HandleInheritability.Inheritable);
            Writer = new StreamWriter(Stream);
            input = Stream.GetClientHandleAsString();
        }
        public override bool XClose()
        {
            Writer.Close();
            Stream.Close();
            return true;
        }

        public override bool XWriteStrings(List<string> strings)
        {
            string data = string.Join("" + Convert.ToChar(0), strings);
            Writer.Write(data);
            Writer.Flush();
            Stream.WaitForPipeDrain();
            return true;
        }
    }
}
