using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Tasks.Architecture
{
    [_XType(typeof(Architect))]
    [_XString("Refine the architecture to an appropriate level of detail to support development.")]
    public class Refine_the_Architecture
    {
        [_XType(typeof(Developer))]
        [_XType(typeof(Project_Manager))]
        public Refine_the_Architecture()
        {

        }
    }
}
