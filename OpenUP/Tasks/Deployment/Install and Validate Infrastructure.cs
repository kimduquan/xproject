using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;

namespace OpenUP.Tasks.Deployment
{
    [_XType(typeof(Deployment_Engineer))]
    [_XType(typeof(Developer))]
    [_XString("Any infrastructure components needed to support a release must be procured, installed, and tested.")]
    public class Install_and_Validate_Infrastructure
    {
    }
}
