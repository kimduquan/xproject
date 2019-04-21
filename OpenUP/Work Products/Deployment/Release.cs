using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Developer))]
    public class Release
    {
        public Deployment_Engineer Responsible { get; set; }
    }
}
