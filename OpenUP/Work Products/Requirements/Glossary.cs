using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Requirements
{
    [_XType(typeof(Analyst))]
    public class Glossary
    {
        public Analyst Responsible { get; set; }
        public Analyst Modified_By { get; set; }
    }
}
