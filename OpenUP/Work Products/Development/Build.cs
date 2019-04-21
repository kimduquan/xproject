using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Development
{
    [_XType(typeof(Developer))]
    public class Build
    {
        public Developer Responsible { get; set; }
    }
}
