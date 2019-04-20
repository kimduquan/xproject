using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Tasks.Project_Management;

namespace OpenUP.Work_Products.Project_Management
{
    [_XType(typeof(Project_Manager))]
    public class Project_Plan : Project_Definition_and_Scope
    {
        public Project_Manager Responsible { get; set; }
        public Project_Manager Modified_By { get; set; }
        public Plan_Project Output_From { get; set; }
    }
}
