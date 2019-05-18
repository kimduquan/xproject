using _XSystem;
using OpenUP.Tasks.Architecture;
using OpenUP.Tasks.Deployment;
using OpenUP.Tasks.Project_Management;
using OpenUP.Tasks.Requirements;
using OpenUP.Tasks.Test;

namespace OpenUP.Roles.Basic_Roles
{
    [_XType(typeof(Assess_Results))]
    [_XType(typeof(Create_Test_Cases))]
    [_XType(typeof(Deliver_Release_Communications))]
    [_XType(typeof(Detail_System_Wide_Requirements))]
    [_XType(typeof(Detail_Use_Case_Scenarios))]
    [_XType(typeof(Develop_Product_Documentation))]
    [_XType(typeof(Envision_the_Architecture))]
    [_XType(typeof(Execute_Backout_Plan))]
    [_XType(typeof(Execute_Deployment_Plan))]
    [_XType(typeof(Identify_and_Outline_Requirements))]
    [_XType(typeof(Implement_Tests))]
    [_XType(typeof(Manage_Iteration))]
    [_XType(typeof(Plan_Deployment))]
    [_XType(typeof(Plan_Iteration))]
    [_XType(typeof(Plan_Project))]
    [_XType(typeof(Refine_the_Architecture))]
    [_XType(typeof(Verify_Successful_Deployment))]
    [_XString("The Developer is responsible for developing a part of the system, including designing it to fit into the architecture, possibly prototyping the user interface, and then implementing, unit-testing, and integrating the components that are part of the solution.")]
    public class Developer : Any_Role
    {
    }
}
