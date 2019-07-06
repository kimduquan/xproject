using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;

namespace OpenUP.Tasks.Deployment
{
    [_XType(typeof(Deployment_Engineer))]
    [_XString("After a product release has been declared a success and is available for use, all relevant stakeholders should receive a communique stating that fact.")]
    public class Deliver_Release_Communications
    {
        [_XType(typeof(Developer))]
        public Deliver_Release_Communications()
        {

        }
    }
}
