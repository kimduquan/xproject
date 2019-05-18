using _XSystem;
using OpenUP.Roles.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XString("Release controls normally are established by IT management and enforced by the deployment manager.")]
    class Release_Controls
    {
        public Deployment_Manager Responsible { get; set; }
    }
}
