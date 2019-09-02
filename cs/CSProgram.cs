using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.IO.Pipes;
using XCS;

namespace cs
{
    public class CSProgram : XProgram
    {
        public CSProgram()
        {
        }

        protected Process Process { get; set; }

        protected override bool XCreateInput(out XInput xinput, out string output)
        {
            bool bRes = true;
            xinput = new PipeInput(out output);
            return bRes;
        }

        protected override bool XCreateOutput(out XOutput xoutput, out string input)
        {
            bool bRes = true;
            xoutput = new PipeOutput(out input);
            return bRes;
        }

        protected override bool XCreateRemoteInput(string input, out XInput xinput)
        {
            xinput = new RemotePipeInput(input);
            return true;
        }

        protected override bool XCreateRemoteOutput(string output, out XOutput xoutput)
        {
            xoutput = new RemotePipeOutput(output);
            return true;
        }

        protected override bool XFunction(XInput xinput, XOutput xouput, XOutput xerror, XOutput xlog)
        {
            return false;
        }

        protected override bool XIsFunction(XInput xinput)
        {
            return false;
        }

        protected override bool XIsProgram(XInput xinput)
        {
            string dir = Directory.GetCurrentDirectory();
            bool bRes = File.Exists(xinput.XFirst + ".bat");
            return bRes;
        }

        protected override bool XStartProgram(XInput xargs, out XProgram xprogram)
        {
            bool bRes = true;
            xprogram = null;
            bRes = xargs.XRead();
            if(bRes)
            {
                List<string> args = null;
                bRes = xargs.XReadStrings(out args);
                if (bRes)
                {
                    Process proc = new Process();
                    proc.StartInfo.WindowStyle = ProcessWindowStyle.Normal;
                    //proc.StartInfo.FileName = xargs.XFirst + ".bat";
                    proc.StartInfo.FileName = "dotnet";
                    proc.StartInfo.UseShellExecute = false;
                    proc.StartInfo.CreateNoWindow = false;
                    proc.StartInfo.Arguments = xargs.XFirst + ".dll " + string.Join(' ', args);
                    bRes = proc.Start();
                    if (bRes)
                    {
                        CSProgram program = new CSProgram();
                        program.Process = proc;
                        xprogram = program;
                    }
                }
            }
            return bRes;
        }
    }
}
