using _XSystem;
using OpenUP.Roles.Environment;

namespace OpenUP.Work_Products.Environment
{
    [_XType(typeof(Tool_Specialist))]
    [_XString("These work products are the tools needed to support the software development effort. ")]
    public class Tools
    {
        public Tool_Specialist Responsible { get; set; }
    }
}
