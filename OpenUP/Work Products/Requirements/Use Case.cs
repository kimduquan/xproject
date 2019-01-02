using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Work_Products.Requirements
{
    public class Use_Case : Technical_Specification
    {
        public Analyst Responsible { get; set; }
        public Analyst Modified_By { get; set; }
    }
}
