using OpenUP.Roles.Basic_Roles;
using System.Collections.Generic;

namespace OpenUP.Work_Products.Requirements
{
    public class Use_Case_Model : List<Use_Case>, Technical_Specification
    {
        public Analyst Responsible { get; set; }
        public Analyst Modified_By { get; set; }
    }
}
