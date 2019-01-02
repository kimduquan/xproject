using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Project_Management
{
    public class Work_Items_List : Project_Status, Project_Work
    {
        public Project_Manager Responsible { get; set; }
    }
}
