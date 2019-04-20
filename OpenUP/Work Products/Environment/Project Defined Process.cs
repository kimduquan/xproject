using _XSystem;
using OpenUP.Roles.Environment;

namespace OpenUP.Work_Products.Environment
{
    [_XType(typeof(Process_Engineer))]
    public class Project_Defined_Process
    {
        public Process_Engineer Responsible { get; set; }
        public Process_Engineer Modified_By { get; set; } 
    }
}
