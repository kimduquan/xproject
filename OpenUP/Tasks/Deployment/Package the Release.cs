using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;

namespace OpenUP.Tasks.Deployment
{
    [_XType(typeof(Developer))]
    [_XString("Each release should be built and packaged in a standard, controlled, and repeatable manner.")]
    public class Package_the_Release
    {
        [_XType(typeof(Deployment_Engineer))]
        public Package_the_Release()
        {

        }
    }
}
