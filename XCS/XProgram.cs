using System.Collections.Generic;

namespace XCS
{
    public abstract class XProgram
    {
        public static readonly string XIN = "in";
        public static readonly string XOUT = "out";
        public static readonly string XERR = "err";
        public static readonly string XLOG = "lo";

        protected abstract bool XCreateInput(string input, out XInput xouput);
        protected abstract bool XCreateOutput(string output, out XOutput xoutput);

        protected Dictionary<string, XProgram> XPrograms { get; set; }
        protected XRemoteInput XInput { get; private set; }
        protected XRemoteOutput XOutput { get; private set; }
        protected XRemoteOutput XError { get; private set; }
        protected XRemoteOutput XLog { get; private set; }

        public XProgram()
        {
            XPrograms = new Dictionary<string, XProgram>();
        }

        public void XMain(XInput xargs)
        {
            bool bRes = xargs.XRead();
            if (bRes)
            {
                string input = xargs.XRead(XIN);
                string output = xargs.XRead(XOUT);
                string error = xargs.XRead(XERR);
                string log = xargs.XRead(XLOG);

                XInput xinput = null;
                XOutput xoutput = null;
                XOutput xerror = null;
                XOutput xlog = null;

                if (input == null)
                {
                    xinput = new XStdInput();
                    xoutput = new XStdOutput();
                    xerror = new XStdOutput();
                    xlog = new XStdOutput();
                }
                else
                {
                    bRes = XCreateInput(input, out xinput);
                    if(bRes)
                    {
                        if(output == null)
                        {
                            xoutput = new XStdOutput();
                        }
                        else
                        {
                            bRes = XCreateOutput(output, out xoutput);
                            if(bRes)
                            {
                                xoutput.XWrite(XOUT, xoutput.XToString());
                                if (error == null)
                                {
                                    xerror = new XStdOutput();
                                }
                                else
                                {
                                    bRes = XCreateOutput(error, out xerror);
                                    if(bRes)
                                    {
                                        xoutput.XWrite(XERR, xerror.XToString());
                                    }
                                }

                                if(bRes)
                                {
                                    if (log == null)
                                    {
                                        xlog = new XStdOutput();
                                    }
                                    else
                                    {
                                        bRes = XCreateOutput(log, out xlog);
                                        if (bRes)
                                        {
                                            xoutput.XWrite(XLOG, xlog.XToString());
                                        }
                                    }
                                }
                                if(bRes)
                                {
                                    bRes = xoutput.XWrite();
                                }
                            }
                        }
                    }
                }

                bRes = XMain(true, xinput, xoutput, xerror, xlog);
                bRes = XClose();
            }
        }

        protected bool XMain(bool main, XInput xinput, XOutput xoutput, XOutput xerror, XOutput xlog)
        {
            bool bRes = true;
            while (bRes)
            {
                bRes = xinput.XRead();
                if (bRes)
                {
                    if (main)
                    {
                        bRes = XIsProgram(xinput);
                        if (bRes)
                        {
                            bRes = _XProgram(xinput, xoutput, xerror, xlog);
                        }
                        else if (XIsFunction(xinput))
                        {
                            bRes = XFunction(xinput, xoutput, xerror, xlog);
                        }
                        else
                        {
                            bRes = false;
                        }
                    }

                    if (bRes)
                    {
                        bRes = xoutput.XWrite();
                        if (bRes)
                        {
                            bRes = xerror.XWrite();
                            if (bRes)
                            {
                                bRes = xoutput.XWrite();
                            }
                        }
                    }
                }
            }
            return bRes;
        }

        protected abstract bool XIsFunction(XInput xinput);
        protected abstract bool XIsProgram(XInput xinput);
        protected abstract bool XFunction(XInput xinput, XOutput xouput, XOutput xerror, XOutput xlog);
        protected abstract bool XStartProgram(XInput xargs, out XProgram xprogram);
        protected abstract bool XCreateInputOutput(out XInput xinput, out XOutput xoutput);

        protected bool _XProgram(XInput xinput, XOutput xoutput, XOutput xerror, XOutput xlog)
        {
            bool bRes = XPrograms.ContainsKey(xinput.XFirst);
            if (bRes)
            {
                XProgram xprogram = XPrograms[xinput.XFirst];
                bRes = xprogram.XMain(false, xprogram.XInput, xprogram.XOutput, xprogram.XError, xprogram.XLog);
            }
            else
            {
                XInput xnewInput = null;
                XOutput xnewOutput = null;
                bRes = XCreateInputOutput(out xnewInput, out xnewOutput);
                if (bRes)
                {
                    string[] args = new string[] { xinput.XFirst, XIN, xnewInput.XToString(), XOUT, xnewOutput.XToString() };
                    XArgs xargs = new XArgs(args);
                    XProgram xprogram = null;
                    bRes = XStartProgram(xargs, out xprogram);
                    if (bRes)
                    {
                        XPrograms[xinput.XFirst] = xprogram;
                        XRemoteInput xremoteInput = new XRemoteInput(xinput, xnewOutput);
                        xprogram.XInput = xremoteInput;
                        XRemoteOutput xremoteOutput = null;
                        XRemoteOutput xremoteError = null;
                        XRemoteOutput xremoteLog = null;
                        bRes = XCreateRemoteOutput(xnewInput.XRead(XOUT), xoutput, out xremoteOutput);
                        if(bRes)
                        {
                            xprogram.XOutput = xremoteOutput;
                            bRes = XCreateRemoteOutput(xnewInput.XRead(XERR), xerror, out xremoteError);
                            if (bRes)
                            {
                                xprogram.XError = xremoteError;
                                bRes = XCreateRemoteOutput(xnewInput.XRead(XLOG), xlog, out xremoteLog);
                                if (bRes)
                                {
                                    xprogram.XLog = xremoteLog;
                                    bRes = XMain(false, xremoteInput, xremoteOutput, xremoteError, xremoteLog);
                                }
                            }
                        }
                    }
                }
            }
            return bRes;
        }

        protected bool XCreateRemoteOutput(string input, XOutput xoutput, out XRemoteOutput xremote)
        {
            XInput xinput = null;
            xremote = null;
            bool bRes = XCreateInput(input, out xinput);
            if(bRes)
            {
                xremote = new XRemoteOutput(xinput, xoutput);
            }
            return bRes;
        }

        public bool XClose()
        {
            bool bRes = true;
            foreach(KeyValuePair<string, XProgram> pair in XPrograms)
            {
                bRes = pair.Value.XClose();
            }
            XPrograms.Clear();
            bRes = XInput.XOutput.XClose();
            bRes = XOutput.XInput.XClose();
            bRes = XError.XInput.XClose();
            bRes = XLog.XInput.XClose();
            return bRes;
        }
    }
}
