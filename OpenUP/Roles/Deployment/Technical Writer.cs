using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Work_Products.Deployment;

namespace OpenUP.Roles.Deployment
{
    [_XType(typeof(Product_Documentation))]
    [_XType(typeof(Support_Documentation))]
    [_XType(typeof(User_Documentation))]
    [_XString("A Technical Writer often helps a development team member complete the documentation needed for the Product Owner, End Users, and support personnel to understand and to be able to use the delivered features.")]
    public class Technical_Writer : Any_Role
    {
    }
}
