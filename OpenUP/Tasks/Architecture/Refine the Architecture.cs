using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Work_Products.Architecture;
using OpenUP.Work_Products.Development;
using OpenUP.Work_Products.Requirements;

namespace OpenUP.Tasks.Architecture
{
    [_XType(typeof(Architect))]
    public class Refine_the_Architecture
    {
        public Refine_the_Architecture(
            Technical_Specification technialSpecification,
            Architecture_Notebook architectureNotebook,
            Technical_Design technicalDesign = null,
            Technical_Implementation technicalImplementation = null
            )
        {

        }
        public Technical_Specification TechnialSpecification { get; }
        public Architecture_Notebook ArchitectureNotebook { get; }
        public Technical_Design TechnicalDesign { get; }
        public Technical_Implementation TechnicalImplementation { get; }
    }
}
