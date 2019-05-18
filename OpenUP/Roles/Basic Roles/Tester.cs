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
    [_XType(typeof(Identify_and_Outline_Requirements))]
    [_XType(typeof(Implement_Developer_Tests))]
    [_XType(typeof(Implement_Solution))]
    [_XType(typeof(Manage_Iteration))]
    [_XType(typeof(Plan_Iteration))]
    [_XType(typeof(Plan_Project))]
    [_XString("The Tester is responsible for the core activities of the test effort. Those activities include identifying, defining, implementing, and conducting the necessary tests, as well as logging the outcomes of the testing and analyzing the results.")]
    public class Tester : Any_Role
    {
    }
}
