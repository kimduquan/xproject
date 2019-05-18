using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Architecture
{
    [_XType(typeof(Architect))]
    [_XString("This artifact describes the rationale, assumptions, explanation, and implications of the decisions that were made in forming the architecture.")]
    public class Architecture_Notebook
    {
        public Architect Responsible { get; set; }
    }
}
