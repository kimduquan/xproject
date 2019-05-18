using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Requirements
{
    [_XType(typeof(Analyst))]
    [_XString("This artifact captures a model of the intended functions and environment of the system and serves as a contract between the customer and the team.")]
    public class Use_Case_Model
    {
        public Analyst Responsible { get; set; }
    }
}
