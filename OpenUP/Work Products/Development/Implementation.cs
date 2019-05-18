using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Development
{
    [_XType(typeof(Developer))]
    [_XString("Software code files, data files, and supporting files (such as online help files) that represent the raw parts of a system that can be built.")]
    public class Implementation
    {
        public Developer Responsible { get; set; }
    }
}
