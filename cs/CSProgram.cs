using XCS;

namespace cs
{
    public class CSProgram : XProgram
    {
        protected override bool XCreateInput(string input, out XInput xouput)
        {
            throw new System.NotImplementedException();
        }

        protected override bool XCreateInputOutput(out XInput xinput, out XOutput xoutput)
        {
            throw new System.NotImplementedException();
        }

        protected override bool XCreateOutput(string output, out XOutput xoutput)
        {
            throw new System.NotImplementedException();
        }

        protected override bool XFunction(XInput xinput, XOutput xouput, XOutput xerror, XOutput xlog)
        {
            throw new System.NotImplementedException();
        }

        protected override bool XIsFunction(XInput xinput)
        {
            throw new System.NotImplementedException();
        }

        protected override bool XIsProgram(XInput xinput)
        {
            throw new System.NotImplementedException();
        }

        protected override bool XStartProgram(XInput xargs, out XProgram xprogram)
        {
            throw new System.NotImplementedException();
        }
    }
}
