using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Development
{
    [_XType(typeof(Developer))]
    [_XString("The Developer Test validates a specific aspect of an implementation element.")]
    public class Developer_Test
    {
        public Developer Responsible { get; set; }
    }
}
