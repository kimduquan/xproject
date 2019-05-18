using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Requirements
{
    [_XType(typeof(Analyst))]
    [_XString("This artifact defines important terms used by the project. The collection of terms clarifies the vocabulary used on the project.")]
    public class Glossary
    {
        public Analyst Responsible { get; set; }
    }
}
