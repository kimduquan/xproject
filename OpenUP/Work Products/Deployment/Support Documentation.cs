using _XSystem;
using OpenUP.Roles.Deployment;
using OpenUP.Tasks.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Technical_Writer))]
    [_XString("Documents used by members of a production support team that provide information about how to service and support a specific product.")]
    public class Support_Documentation
    {
        public Technical_Writer Responsible { get; set; }
    }
}
