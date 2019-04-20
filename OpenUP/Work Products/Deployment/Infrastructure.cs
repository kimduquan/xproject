using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;
using OpenUP.Tasks.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Deployment_Engineer))]
    [_XType(typeof(Developer))]
    public class Infrastructure
    {
        public Install_and_Validate_Infrastructure Output_From { get; set; }
    }
}
