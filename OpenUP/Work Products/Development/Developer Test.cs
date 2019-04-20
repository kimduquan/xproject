using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Tasks.Development;

namespace OpenUP.Work_Products.Development
{
    [_XType(typeof(Developer))]
    public class Developer_Test
    {
        public Developer Responsible { get; set; }
        public Developer Modified_By { get; set; }
        public Implement_Developer_Tests Output_From { get; set; }
    }
}
