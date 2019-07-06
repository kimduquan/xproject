using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;

namespace OpenUP.Tasks.Deployment
{
    [_XType(typeof(Deployment_Engineer))]
    [_XString("The deployment plan has all the unique instructions necessary to roll out a release.")]
    public class Execute_Deployment_Plan
    {
        [_XType(typeof(Developer))]
        public Execute_Deployment_Plan()
        {

        }
    }
}
