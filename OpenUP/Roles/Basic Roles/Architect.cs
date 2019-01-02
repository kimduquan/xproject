using OpenUP.Work_Products.Architecture;
using OpenUP.Work_Products.Development;
using OpenUP.Work_Products.Requirements;

namespace OpenUP.Roles.Basic_Roles
{
    public interface Architect
    {
        Architecture_Notebook Refine_the_Architecture(
            Technical_Specification technical_Specification, 
            Architecture_Notebook architecture_Notebook, 
            Technical_Design technical_Design = null,
            Technical_Implementation technical_Implementation = null
            );

        Architecture_Notebook Envision_the_Architecture(
            Technical_Specification technical_Specification, 
            Architecture_Notebook architecture_Notebook = null
            );
    }
}
