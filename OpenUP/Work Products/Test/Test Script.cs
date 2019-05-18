using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Tasks.Test;

namespace OpenUP.Work_Products.Test
{
    [_XType(typeof(Tester))]
    [_XString("This artifact contains the step-by-step instructions that compose a test, enabling its run. Text scripts can take the form of either documented textual instructions that are manually followed, or computer-readable instructions that enable automated testing.")]
    public class Test_Script
    {
        public Tester Responsible { get; set; }
    }
}
