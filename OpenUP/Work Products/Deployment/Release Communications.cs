using _XSystem;
using OpenUP.Roles.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Deployment_Engineer))]
    public class Release_Communications
    {
        public Deployment_Engineer Responsible { get; set; }
    }
}
