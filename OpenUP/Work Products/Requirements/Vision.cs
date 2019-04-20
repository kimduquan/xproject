using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Tasks.Requirements;

namespace OpenUP.Work_Products.Requirements
{
    [_XType(typeof(Analyst))]
    public class Vision
    {
        public Analyst Responsible { get; set; }
        public Analyst Modified_By { get; set; }
        public Develop_Technical_Vision Output_From { get; set; }
    }
}
