using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Project_Management
{
    [_XType(typeof(Project_Manager))]
    [_XString("This artifact is a sorted list of known and open risks to the project, sorted in order of importance and associated with specific mitigation or contingency actions.")]
    public class Risk_List
    {
        public Project_Manager Responsible { get; set; }
    }
}
