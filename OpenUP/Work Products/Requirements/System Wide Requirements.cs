using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Requirements
{
    [_XType(typeof(Analyst))]
    [_XString("This artifact captures the quality attributes and constraints that have system-wide scope. It also captures system-wide functional requirements.")]
    public class System_Wide_Requirements
    {
        public Analyst Responsible { get; set; }
    }
}
