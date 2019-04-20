using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Tasks.Test;

namespace OpenUP.Work_Products.Test
{
    [_XType(typeof(Tester))]
    public class Test_Script
    {
        public Tester Responsible { get; set; }
        public Tester ModifiedBy { get; set; }
        public Implement_Tests Output_From { get; set; }
    }
}
