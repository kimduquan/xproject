using _XSystem;
using OpenUP.Work_Products.Test;

namespace OpenUP.Roles.Basic_Roles
{
    [_XType(typeof(Test_Case))]
    [_XType(typeof(Test_Log))]
    [_XType(typeof(Test_Script))]
    [_XString("The Tester is responsible for the core activities of the test effort. Those activities include identifying, defining, implementing, and conducting the necessary tests, as well as logging the outcomes of the testing and analyzing the results.")]
    public class Tester : Any_Role
    {
    }
}
