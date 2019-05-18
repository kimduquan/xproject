using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Test
{
    [_XType(typeof(Developer))]
    [_XType(typeof(Tester))]
    [_XString("This artifact collects the raw output that is captured during a unique run of one or more tests for a single test cycle run.")]
    public class Test_Log
    {
        public Tester Responsible { get; set; }
    }
}
