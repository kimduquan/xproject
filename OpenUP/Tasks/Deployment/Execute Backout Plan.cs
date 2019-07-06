using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;

namespace OpenUP.Tasks.Deployment
{
    [_XType(typeof(Deployment_Engineer))]
    [_XString("If a particular release into production goes wrong, the plan for cleanly reversing that deployment is executed.")]
    public class Execute_Backout_Plan
    {
        [_XType(typeof(Developer))]
        public Execute_Backout_Plan()
        {

        }
    }
}
