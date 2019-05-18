using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Project_Management
{
    [_XType(typeof(Project_Manager))]
    [_XString("This artifact gathers all of the information required to manage the project on a strategic level. Its main part consists of a coarse-grained plan, identifying project iterations and their goals.")]
    public class Project_Plan
    {
        public Project_Manager Responsible { get; set; }
    }
}
