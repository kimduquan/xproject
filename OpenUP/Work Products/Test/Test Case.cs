using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Tasks.Test;

namespace OpenUP.Work_Products.Test
{
    [_XType(typeof(Tester))]
    public class Test_Case
    {
        public Tester Responsible { get; set; }
        public Tester ModifiedBy { get; set; }
        public Create_Test_Cases Output_From { get; set; }
    }
}
