using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Tasks.Requirements
{
    [_XType(typeof(Analyst))]
    [_XString("This task describes how to identify and outline the requirements for the system so that the scope of work can be determined.")]
    public class Identify_and_Outline_Requirements
    {
        [_XType(typeof(Architect))]
        [_XType(typeof(Developer))]
        [_XType(typeof(Stakeholder))]
        [_XType(typeof(Tester))]
        public Identify_and_Outline_Requirements()
        {

        }
    }
}
