using _XSystem;
using OpenUP.Work_Products.Project_Management;

namespace OpenUP.Roles.Basic_Roles
{
    [_XType(typeof(Iteration_Plan))]
    [_XType(typeof(Project_Plan))]
    [_XType(typeof(Risk_List))]
    [_XType(typeof(Work_Items_List))]
    [_XString("The Project Manager leads the planning of the project, coordinates interactions with the stakeholders, and keeps the project team focused on meeting the project objectives.")]
    public class Project_Manager : Any_Role
    {
    }
}
