using _XSystem;
using System.Collections.Generic;

namespace OpenUP.Guidance.Templates
{
    [_XString("This is the informal template suggested for representing design.A requirements realization is a part of the design that shows how one or more requirements is implemented.")]
    public struct Design : Template
    {
        [_XString("Describe the design from the highest level. This is commonly done with a diagram that shows a layered architecture.")]
        public object Design_structure { get; set; }

        public Dictionary<string, Sub_system> Subsystems { get; set; }

        public Dictionary<string, Pattern> Patterns { get; set; }

        public Dictionary<string, Realization> Requirement_realizations { get; set; }

        [_XString("Describe the design of a portion of the system (a package or component, for instance). The design should capture both static and dynamic perspectives.\nWhen capturing dynamic descriptions of behavior, look for reusable chunks of behavior that you can reference to simplify the design of the requirement realizations.\nYou can break this section down into lower - level subsections to describe lower - level, encapsulated subsystems.")]
        public struct Sub_system
        {

        }
        public struct Pattern
        {
            [_XString("Provide an overview of the pattern in words in some consistent form. The overview of a pattern can include the intent, motivation, and applicability.")]
            public object Overview { get; set; }

            [_XString("Describe the pattern from a static perspective. Include all of the participants and how they relate to one another, and call out the relevant data and behavior.")]
            public object Structure { get; set; }

            [_XString("Describe the pattern from a dynamic perspective. Walk the reader through how the participants collaborate to support various scenarios.")]
            public object Behavior { get; set; }

            [_XString("Often, you can convey the nature of the pattern better with an additional concrete example.")]
            public object Example { get; set; }
        }
        public struct Realization
        {
            [_XString("Describe the participating design elements from a static perspective, giving details such as behavior, relationships, and attributes relevant to this realization.")]
            public object View_of_participants { get; set; }

            [_XString("For the main flow, describe how instances of the design elements collaborate to realize the requirements. When using UML, this can be done with collaboration diagrams (sequence or communication).")]
            public object Basic_scenario { get; set; }

            [_XString("For other scenarios that must be described to convey an appropriate amount of information about how the requirement behavior will be realized, describe how instances of the design elements collaborate to realize the requirement. When using UML, you can do this with collaboration diagrams (sequence or communication).")]
            public object Additional_scenarios { get; set; }
        }
    }
}
