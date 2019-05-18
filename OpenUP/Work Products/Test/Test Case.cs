using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Tasks.Test;

namespace OpenUP.Work_Products.Test
{
    [_XType(typeof(Tester))]
    [_XString("This artifact is the specification of a set of test inputs, execution conditions, and expected results that you identify to evaluate a particular aspect of a scenario.")]
    public class Test_Case
    {
        public Tester Responsible { get; set; }
    }
}
