using _XSystem;
using OpenUP.Work_Products.Deployment;
using OpenUP.Work_Products.Development;
using OpenUP.Work_Products.Test;

namespace OpenUP.Roles.Basic_Roles
{
    [_XType(typeof(Backout_Plan))]
    [_XType(typeof(Build))]
    [_XType(typeof(Design))]
    [_XType(typeof(Developer_Test))]
    [_XType(typeof(Implementation))]
    [_XType(typeof(Infrastructure))]
    [_XType(typeof(Release))]
    [_XType(typeof(Test_Log))]
    [_XString("The Developer is responsible for developing a part of the system, including designing it to fit into the architecture, possibly prototyping the user interface, and then implementing, unit-testing, and integrating the components that are part of the solution.")]
    public class Developer : Any_Role
    {
    }
}
