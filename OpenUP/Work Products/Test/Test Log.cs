using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Test
{
    [_XType(typeof(Developer))]
    [_XType(typeof(Tester))]
    public class Test_Log
    {
        public Tester Responsible { get; set; }
    }
}
