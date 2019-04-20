using _XSystem;
using OpenUP.Roles.Environment;

namespace OpenUP.Work_Products.Environment
{
    [_XType(typeof(Tool_Specialist))]
    public class Tools
    {
        public Tool_Specialist Responsible { get; set; }
        public Tool_Specialist Modified_By { get; set; }
    }
}
