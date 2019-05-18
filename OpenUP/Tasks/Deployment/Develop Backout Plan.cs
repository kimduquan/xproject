using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;

namespace OpenUP.Tasks.Deployment
{
    [_XType(typeof(Developer))]
    [_XString("This task results in a plan to be used by the production support organization to roll back the release if there is a problem during or after deployment.")]
    public class Develop_Backout_Plan
    {
    }
}
