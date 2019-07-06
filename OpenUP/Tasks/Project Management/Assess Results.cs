using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Tasks.Project_Management
{
    [_XType(typeof(Project_Manager))]
    [_XString("Determine success or failure of the iteration. Apply the lessons learned to modify the project or improve the process.")]
    public class Assess_Results
    {
        [_XType(typeof(Analyst))]
        [_XType(typeof(Architect))]
        [_XType(typeof(Developer))]
        [_XType(typeof(Stakeholder))]
        [_XType(typeof(Tester))]
        public Assess_Results()
        {

        }
    }
}
