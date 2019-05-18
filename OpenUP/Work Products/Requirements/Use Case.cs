using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Requirements
{
    [_XType(typeof(Analyst))]
    [_XString("This artifact captures the system behavior to yield an observable result of value to those who interact with the system.")]
    public class Use_Case
    {
        public Analyst Responsible { get; set; }
    }
}
