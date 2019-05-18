using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Project_Management
{
    [_XType(typeof(Project_Manager))]
    [_XString("A fine-grained plan describing the objectives, work assignments, and evaluation criteria for the iteration.")]
    public class Iteration_Plan
    {
        public Project_Manager Responsible { get; set; }
    }
}
