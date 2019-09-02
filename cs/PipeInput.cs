using System;
using System.Collections.Generic;
using System.IO;
using System.IO.Pipes;
using XCS;

namespace cs
{
    public class PipeInput : XInput
    {
        public AnonymousPipeServerStream Stream { get; protected set; }
        protected StreamReader Reader { get; set; }

        public PipeInput(out string output)
        {
            Stream = new AnonymousPipeServerStream(PipeDirection.In, HandleInheritability.Inheritable);
            Reader = new StreamReader(Stream);
            output = Stream.GetClientHandleAsString();
        }
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
            strings = new List<string>();
            strings.AddRange(data.Split(Convert.ToChar(0)));
            return true;
        }
    }
}
