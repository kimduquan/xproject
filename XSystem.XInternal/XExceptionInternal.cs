using System;

namespace XSystem.XInternal
{
    public class XExceptionInternal : XException
    {
        private Exception ex = null;
        private X x = null;
        private XException xinnerException = null;

        public XExceptionInternal(Exception e, X xx)
        {
            ex = e;
            x = xx;
        }

        public string XMessage => ex.Message;

        public XException XInnerException
        {
            get
            {
                if(xinnerException == null)
                {
                    if(ex.InnerException != null)
                        xinnerException = x.XCatch(ex.InnerException);
                }
                return xinnerException;
            }
        }
    }
}
