using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Project_Management
{
    public class Iteration_Plan : Project_Status, Project_Work
    {
        public Project_Manager Responsible { get; set; }
        public Project_Manager Modified_By { get; set; }
    }
}
