using _XSystem;
using OpenUP.Roles.Environment;

namespace OpenUP.Work_Products.Environment
{
    [_XType(typeof(Process_Engineer))]
    [_XString("This work product describes the process that a project is to follow in order to produce the project's desired results.")]
    public class Project_Defined_Process
    {
        public Process_Engineer Responsible { get; set; }
    }
}
