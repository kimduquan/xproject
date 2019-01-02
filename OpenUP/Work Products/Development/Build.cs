using OpenUP.Roles.Basic_Roles;
using OpenUP.Tasks.Development;

namespace OpenUP.Work_Products.Development
{
    public class Build : Technical_Implementation
    {
        public Developer Responsible { get; set; }
        public Developer Modified_By { get; set; }
        public Integrate_and_Create_Build Output_From { get; set; }
    }
}
