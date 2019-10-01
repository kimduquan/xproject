using _XSystem;
using System.Collections.Generic;

namespace OpenUP.Guidance.Templates
{
    [_XString("This is a spreadsheet suggested for representing a work items list. Alternative templates would be usage of a specific tool or database with similar information.")]
    public struct Work_Items_List : Template
    {
        public List<Work_Item> Work_Items { get; set; }
        public struct Work_Item
        {
            public object Description { get; set; }
            public object Priority { get; set; }

            public object Size_estimate { get; set; }
            public object State { get; set; }
            public object Target_iteration { get; set; }
            public object Assigned_To { get; set; }
            public object Effort_estimate_left { get; set; }
            public object Hours_worked { get; set; }
            public object Reference_material { get; set; }
        }
    }
}
