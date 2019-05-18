using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Development
{
    [_XType(typeof(Developer))]
    [_XString("This artifact describes the realization of required system functionality and serves as an abstraction of the source code.")]
    public class Design
    {
        public Developer Responsible { get; set; }
    }
}
