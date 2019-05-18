using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Developer))]
    [_XString("A backout plan defines the criteria and procedures to be followed if a release into production needs to be rolled back.")]
    public class Backout_Plan
    {
        public Deployment_Engineer Responsible { get; set; }
    }
}
