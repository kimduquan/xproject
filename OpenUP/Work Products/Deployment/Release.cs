using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;
using OpenUP.Tasks.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Developer))]
    public class Release
    {
        public Deployment_Engineer Responsible { get; set; }
        public Developer Modified_By { get; set; }
        public Package_the_Release Output_From { get; set; }
    }
}
