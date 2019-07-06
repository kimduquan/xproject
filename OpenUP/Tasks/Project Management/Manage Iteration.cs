using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Tasks.Project_Management
{
    [_XType(typeof(Project_Manager))]
    [_XString("Assess project status and identify any blocking issues and opportunities. Identify and manage exceptions, problems, and risks. Communicate project status.")]
    public class Manage_Iteration
    {
        [_XType(typeof(Analyst))]
        [_XType(typeof(Architect))]
        [_XType(typeof(Developer))]
        [_XType(typeof(Stakeholder))]
        [_XType(typeof(Tester))]
        public Manage_Iteration()
        {

        }
    }
}
