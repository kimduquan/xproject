using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Tasks.Requirements;

namespace OpenUP.Work_Products.Requirements
{
    [_XType(typeof(Analyst))]
    [_XString("This artifact defines the view of the stakeholders of the technical solution to be developed. This definition is specified in terms of the key needs and features of the stakeholders. The vision contains an outline of the envisioned core requirements for the system.")]
    public class Vision
    {
        public Analyst Responsible { get; set; }
    }
}
