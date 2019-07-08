using XSystem;

namespace XWebApplication.Models.XSystem
{
    public class _XExceptionModel
    {
        private XException xexception = null;

        public _XExceptionModel(XException ex)
        {
            xexception = ex;
        }

        public string XMessage { get; set; }
    }
}
