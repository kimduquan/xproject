using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Project_Management
{
    [_XType(typeof(Analyst))]
    [_XType(typeof(Any_Role))]
    [_XType(typeof(Project_Manager))]
    public class Work_Items_List
    {
        public Project_Manager Responsible { get; set; }
    }
}
