using _XSystem;
using System;
using System.Collections.Generic;

namespace OpenUP.Guidance.Templates
{
    [_XString("This is a template for an iteration plan.")]
    public struct Iteration_Plan : Template
    {
        public string Project_Name { get; set; }
        public DateTime Date { get; set; }

        [_XString("Key dates showing timelines, such as start and end date; intermediate milestones; synchronization points with other teams; demos; and so on for the iteration.")]
        public List<_Milestone> Key_milestones { get; set; }

        [_XString("List the key objectives for the iteration, typically one to five.")]
        public List<object> High_level_objectives { get; set; }

        public Work_Items_List Work_Item_assignments { get; set; }

        [_XString("List any issues to be solved during the iteration. Update status when new issues are reported during the daily meetings")]
        public List<_Issue> Issues { get; set; }

        [_XString("A brief description of how to evaluate whether the high-level objectives were met.")]
        public object Evaluation_criteria { get; set; }

        [_XString("Document whether you addressed the objectives as specified in the Iteration Plan.")]
        public object Assessment_against_objectives { get; set; }

        [_XString("Summarize whether all Work Items planned to be addressed in the iteration were addressed, and which Work Items were postponed or added.")]
        public object Work_Items_Planned_compared_to_actually_completed { get; set; }

        [_XString("Document whether you met the evaluation criteria as specified in the Iteration Plan. This could include information such as “Demo for Department X was well-received, with some concerns raised around usability,” or “495 test cases were automated with a 98% pass rate. 9 test cases were deferred because the corresponding Work Items were postponed.")]
        public object Assessment_against_Evaluation_Criteria_Test_results { get; set; }

        [_XString("List other areas that have been evaluated, such as financials, or schedule deviation, as well as Stakeholder feedback not captured elsewhere.")]
        public object Other_concerns_and_deviations { get; set; }

        public struct _Milestone
        {
            public string Milestone { get; set; }
            DateTime Date { get; set; }
        }

        public struct _Issue
        {
            public object Issue { get; set; }
            public object Status { get; set; }
            public object Notes { get; set; }
        }
    }
}
