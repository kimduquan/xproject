using _XSystem;
using OpenUP.Tasks.Development;
using OpenUP.Tasks.Project_Management;
using OpenUP.Tasks.Requirements;

namespace OpenUP.Roles.Basic_Roles
{
    [_XType(typeof(Assess_Results))]
    [_XType(typeof(Design_the_Solution))]
    [_XType(typeof(Detail_System_Wide_Requirements))]
    [_XType(typeof(Detail_Use_Case_Scenarios))]
    [_XType(typeof(Develop_Technical_Vision))]
    [_XType(typeof(Identify_and_Outline_Requirements))]
    [_XType(typeof(Manage_Iteration))]
    [_XType(typeof(Plan_Iteration))]
    [_XType(typeof(Plan_Project))]
    [_XString("The Architect is responsible for defining the software architecture, which includes making the key technical decisions that constrain the overall design and implementation of the system.")]
    public class Architect : Any_Role
    {
    }
}
