using System;
using System.Collections.Generic;

namespace XCS
{
    public abstract class XProgram
    {
        public static readonly string XIN = "in";
        public static readonly string XOUT = "out";
        public static readonly string XERR = "err";
        public static readonly string XLOG = "lo";
        public static readonly string XDEBUG = "debug";

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
                    bRes = XCreateRemoteInput(input, out xinput);
                    if(bRes)
                    {
                        if(output == null)
                        {
                            xoutput = new XStdOutput();
                            if (error == null)
                            {
                                xerror = new XStdOutput();
                            }
                            else
                            {
                                bRes = XCreateRemoteOutput(error, out xerror);
                            }

                            if (log == null)
                            {
                                xlog = new XStdOutput();
                            }
                            else
                            {
                                bRes = XCreateRemoteOutput(log, out xlog);
                            }
                        }
                        else
                        {
                            XOutput xparentOutput = null;
                            bRes = XCreateRemoteOutput(output, out xparentOutput);
                            if(bRes)
                            {
                                string newOutput = null;
                                bRes = XCreateOutput(out xoutput, out newOutput);
                                if(bRes)
                                {
                                    xparentOutput.XWrite(XOUT, newOutput);
                                }
                                if (bRes)
                                {
                                    string newError = null;
                                    bRes = XCreateOutput(out xerror, out newError);
                                    if(bRes)
                                    {
                                        xparentOutput.XWrite(XERR, newError);
                                    }
                                }

                                if (bRes)
                                {
                                    string newLog = null;
                                    bRes = XCreateOutput(out xlog, out newLog);
                                    if (bRes)
                                    {
                                        xparentOutput.XWrite(XLOG, newLog);
                                    }
                                }

                                if (bRes)
                                {
                                    bRes = xparentOutput.XWrite();
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
                        else 
                        {
                            bRes = XIsFunction(xinput);
                            if (bRes)
                            {
                                bRes = XFunction(xinput, xoutput, xerror, xlog);
                            }
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
                string childInputRead = null;
                XOutput xchildInputWrite = null;
                bRes = XCreateOutput(out xchildInputWrite, out childInputRead);
                string childOutputWrite = null;
                XInput xchildOutputRead = null;
                bRes = XCreateInput(out xchildOutputRead, out childOutputWrite);
                if (bRes)
                {
                    string[] args = new string[] { xinput.XFirst, XIN, childInputRead, XOUT, childOutputWrite };
                    XArgs xargs = new XArgs(args);
                    XProgram xprogram = null;
                    bRes = XStartProgram(xargs, out xprogram);
                    if (bRes)
                    {
                        XPrograms[xinput.XFirst] = xprogram;
                        bRes = xchildOutputRead.XRead();
                        if(bRes)
                        {
                            string childOutputRead = xchildOutputRead.XRead(XOUT);
                            XInput xremoteChildOutput = null;
                            bRes = XCreateRemoteInput(childOutputRead, out xremoteChildOutput);
                            if (bRes)
                            {
                                string childErrorRead = xchildOutputRead.XRead(XERR);
                                XInput xremoteChildError = null;
                                bRes = XCreateRemoteInput(childErrorRead, out xremoteChildError);
                                if (bRes)
                                {
                                    string childLogRead = xchildOutputRead.XRead(XLOG);
                                    XInput xremoteChildLog = null;
                                    bRes = XCreateRemoteInput(childLogRead, out xremoteChildLog);
                                    if (bRes)
                                    {
                                        xprogram.XInput = new XRemoteInput(xinput, xchildInputWrite);
                                        xprogram.XOutput = new XRemoteOutput(xoutput, xremoteChildOutput);
                                        xprogram.XError = new XRemoteOutput(xerror, xremoteChildError);
                                        xprogram.XLog = new XRemoteOutput(xlog, xremoteChildLog);
                                        bRes = XMain(false, xprogram.XInput, xprogram.XOutput, xprogram.XError, xprogram.XLog);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return bRes;
        }

        protected abstract bool XCreateInput(out XInput xintput, out string output);
        protected abstract bool XCreateOutput(out XOutput xoutput, out string input);
        protected abstract bool XCreateRemoteInput(string input, out XInput xinput);
        protected abstract bool XCreateRemoteOutput(string output, out XOutput xoutput);

        public bool XClose()
        {
            bool bRes = true;
            foreach(KeyValuePair<string, XProgram> pair in XPrograms)
            {
                bRes = pair.Value.XClose();
            }
            XPrograms.Clear();
            if(XInput != null)
            {
                bRes = XInput.XOutput.XClose();
            }
            if(XOutput != null)
            {
                bRes = XOutput.XInput.XClose();
            }
            if(XError != null)
            {
                bRes = XError.XInput.XClose();
            }
            if(XLog != null)
            {
                bRes = XLog.XInput.XClose();
            }
            return bRes;
        }
    }
}
