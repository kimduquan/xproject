using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Development
{
    [_XType(typeof(Developer))]
    [_XString("An operational version of a system or part of a system that demonstrates a subset of the capabilities to be provided in the final product.")]
    public class Build
    {
        public Developer Responsible { get; set; }
    }
}
