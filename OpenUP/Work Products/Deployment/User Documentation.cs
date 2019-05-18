using _XSystem;
using OpenUP.Roles.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Technical_Writer))]
    [_XString("Documents that can be utilized by the end users of a particular system or product. This type of documentation typically is written in a way that enables system users to easily find information they need to use the product.")]
    public class User_Documentation
    {
        public Technical_Writer Responsible { get; set; }
    }
}
