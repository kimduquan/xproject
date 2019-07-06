using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Tasks.Requirements
{
    [_XType(typeof(Analyst))]
    [_XString("This task details one or more requirement that does not apply to a specific use case.")]
    public class Detail_System_Wide_Requirements
    {
        [_XType(typeof(Architect))]
        [_XType(typeof(Developer))]
        [_XType(typeof(Stakeholder))]
        [_XType(typeof(Tester))]
        public Detail_System_Wide_Requirements()
        {

        }
    }
}
