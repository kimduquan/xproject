using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Tasks.Project_Management
{
    [_XType(typeof(Project_Manager))]
    [_XString("Plan the scope and responsibilities for a single iteration.")]
    public class Plan_Iteration
    {
        [_XType(typeof(Analyst))]
        [_XType(typeof(Architect))]
        [_XType(typeof(Developer))]
        [_XType(typeof(Stakeholder))]
        [_XType(typeof(Tester))]
        public Plan_Iteration()
        {

        }
    }
}
