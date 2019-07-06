using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;

namespace OpenUP.Tasks.Deployment
{
    [_XType(typeof(Technical_Writer))]
    [_XString("Because product documentation continues to be used after a development effort ends, it is important to ensure that the features developed within a particular release are clearly documented while the functionality is still fresh in the minds of team members.")]
    public class Develop_Product_Documentation
    {
        [_XType(typeof(Developer))]
        [_XType(typeof(Product_Owner))]
        public Develop_Product_Documentation()
        {

        }
    }
}
