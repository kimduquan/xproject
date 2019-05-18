using _XSystem;
using OpenUP.Roles.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Deployment_Engineer))]
    [_XString("A deployment plan is used to document all the information needed by deployment engineers to deploy a release successfully.")]
    public class Deployment_Plan
    {
        public Deployment_Engineer Responsible { get; set; }
    }
}
