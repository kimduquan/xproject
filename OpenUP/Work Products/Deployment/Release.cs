using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Developer))]
    [_XString("A release is the transition of an increment of potentially shippable product from the development group into routine use by customers based on a successful placement of a release sprint's output into the production environment.")]
    public class Release
    {
        public Deployment_Engineer Responsible { get; set; }
    }
}
