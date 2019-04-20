using _XSystem;
using OpenUP.Roles.Deployment;
using OpenUP.Tasks.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Deployment_Engineer))]
    public class Release_Communications
    {
        public Deployment_Engineer Responsible { get; set; }
        public Deployment_Engineer Modified_By { get; set; }
        public Develop_Release_Communications Output_From { get; set; }
    }
}
