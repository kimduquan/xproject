using OpenUP.Roles.Basic_Roles;
using OpenUP.Tasks.Development;

namespace OpenUP.Work_Products.Development
{
    public class Design
    {
        public Developer Responsible { get; set; }
        public Developer Modified_By { get; set; }
        public Design_the_Solution Output_From { get; set; }
    }
}
