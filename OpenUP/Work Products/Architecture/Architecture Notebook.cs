using _XSystem;
using OpenUP.Roles.Basic_Roles;
using System;

namespace OpenUP.Work_Products.Architecture
{
    [_XType(typeof(Architect))]
    public class Architecture_Notebook : Technical_Architecture
    {
        public Architect Responsible { get; set; }
        public Architect Modified_By { get; set; }
        public string Project_Name { get; set; }
        public DateTime Date { get; set; }
    }
}
