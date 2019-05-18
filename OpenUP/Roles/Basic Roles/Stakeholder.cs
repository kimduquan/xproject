using _XSystem;
using OpenUP.Tasks.Architecture;
using OpenUP.Tasks.Development;
using OpenUP.Tasks.Project_Management;
using OpenUP.Tasks.Requirements;
using OpenUP.Tasks.Test;

namespace OpenUP.Roles.Basic_Roles
{
    [_XType(typeof(Assess_Results))]
    [_XType(typeof(Create_Test_Cases))]
    [_XType(typeof(Design_the_Solution))]
    [_XType(typeof(Detail_System_Wide_Requirements))]
    [_XType(typeof(Detail_Use_Case_Scenarios))]
    [_XType(typeof(Develop_Technical_Vision))]
    [_XType(typeof(Envision_the_Architecture))]
    [_XType(typeof(Identify_and_Outline_Requirements))]
    [_XType(typeof(Implement_Solution))]
    [_XType(typeof(Implement_Tests))]
    [_XType(typeof(Manage_Iteration))]
    [_XType(typeof(Plan_Iteration))]
    [_XType(typeof(Plan_Project))]
    [_XString("This role represents interest groups whose needs must be satisfied by the project. It is a role that may be played by anyone who is (or potentially will be) materially affected by the outcome of the project.")]
    public class Stakeholder : Any_Role
    {
    }
}
