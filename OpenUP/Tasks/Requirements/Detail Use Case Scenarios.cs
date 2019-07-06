using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Tasks.Requirements
{
    [_XType(typeof(Analyst))]
    [_XString("This task describes how to detail a use-case scenarios for the system.")]
    public class Detail_Use_Case_Scenarios
    {
        [_XType(typeof(Architect))]
        [_XType(typeof(Developer))]
        [_XType(typeof(Stakeholder))]
        [_XType(typeof(Tester))]
        public Detail_Use_Case_Scenarios()
        {

        }
    }
}
