using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Project_Management
{
    [_XType(typeof(Analyst))]
    [_XType(typeof(Any_Role))]
    [_XType(typeof(Project_Manager))]
    [_XString("This artifact contains a list of all of the scheduled work to be done within the project, as well as proposed work that may affect the product in this or future projects. Each work item may contain references to information relevant to carry out the work described within the work item.")]
    public class Work_Items_List
    {
        public Project_Manager Responsible { get; set; }
    }
}
