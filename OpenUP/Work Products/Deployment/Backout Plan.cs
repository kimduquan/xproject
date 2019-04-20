using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;
using OpenUP.Tasks.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Developer))]
    public class Backout_Plan
    {
        public Deployment_Engineer Responsible { get; set; }
        public Developer Modified_By { get; set; }
        public Develop_Backout_Plan Output_From { get; set; }
    }
}
