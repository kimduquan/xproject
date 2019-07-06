using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;

namespace OpenUP.Tasks.Deployment
{
    [_XType(typeof(Deployment_Engineer))]
    [_XString("If a deployment plan for the project already exists, update it to reflect the nature of this release. If this document does not exist, develop a deployment plan to indicate how this release will be rolled out to the production environment.")]
    public class Plan_Deployment
    {
        [_XType(typeof(Developer))]
        public Plan_Deployment()
        {

        }
    }
}
