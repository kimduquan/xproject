using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Tasks.Deployment;

namespace OpenUP.Roles.Deployment
{
    [_XType(typeof(Develop_Product_Documentation))]
    [_XType(typeof(Verify_Successful_Deployment))]
    [_XString("The Product Owner represents the End User's needs and defines the \"work\" in the project. This team member typically is co-located with a development team.")]
    public class Product_Owner : Any_Role
    {
    }
}
