using _XSystem;
using OpenUP.Roles.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Technical_Writer))]
    [_XString("Information about a specific product that has been captured in an organized format.")]
    public class Product_Documentation
    {
        public Technical_Writer Responsible { get; set; }
    }
}
