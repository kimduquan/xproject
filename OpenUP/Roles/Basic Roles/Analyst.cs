using _XSystem;
using OpenUP.Tasks.Architecture;
using OpenUP.Tasks.Development;
using OpenUP.Tasks.Project_Management;
using OpenUP.Tasks.Test;

namespace OpenUP.Roles.Basic_Roles
{
    [_XType(typeof(Assess_Results))]
    [_XType(typeof(Create_Test_Cases))]
    [_XType(typeof(Design_the_Solution))]
    [_XType(typeof(Envision_the_Architecture))]
    [_XType(typeof(Implement_Tests))]
    [_XType(typeof(Manage_Iteration))]
    [_XType(typeof(Plan_Iteration))]
    [_XType(typeof(Plan_Project))]
    [_XString("The person in this role represents customer and end-user concerns by gathering input from stakeholders to understand the problem to be solved and by capturing and setting priorities for requirements.")]
    public class Analyst : Any_Role
    {
    }
}
