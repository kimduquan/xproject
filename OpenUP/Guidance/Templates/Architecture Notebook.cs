using _XSystem;
using System;
using System.Collections.Generic;

namespace OpenUP.Guidance.Templates
{
    [_XString("Template for describing the architecture.")]
    public struct Architecture_Notebook : Template
    {
        public string Project_Name { get; set; }
        public DateTime Date { get; set; }

        [_XString("This document describes the philosophy, decisions, constraints, justifications, significant elements, and any other overarching aspects of the system that shape the design and implementation.")]
        public object Purpose { get; set; }

        [_XString("Describe the philosophy of the architecture. Identify issues that will drive the philosophy, such as: Will the system be driven by complex deployment concerns, adapting to legacy systems, or performance issues? Does it need to be robust for long-term maintenance?")]
        public object Architectural_goals_and_philosophy { get; set; }

        [_XString("List the assumptions and dependencies that drive architectural decisions. This could include sensitive or critical areas, dependencies on legacy interfaces, the skill and experience of the team, the availability of important resources, and so forth")]
        public object Assumptions_and_dependencies { get; set; }

        [_XString("Insert a reference or link to the requirements that must be implemented to realize the architecture.")]
        public object Architecturally_significant_requirements { get; set; }

        [_XString("List the decisions that have been made regarding architectural approaches and the constraints being placed on the way that the developers build the system. These will serve as guidelines for defining architecturally significant parts of the system. Justify each decision or constraint so that developers understand the importance of building the system according to the context created by those decisions and constraints. This may include a list of DOs and DON’Ts to guide the developers in building the system.")]
        public List<object> Decisions_constraints_and_justifications { get; set; }

        [_XString("List the architectural mechanisms and describe the current state of each one. Initially, each mechanism may be only name and a brief description. They will evolve until the mechanism is a collaboration or pattern that can be directly applied to some aspect of the design.")]
        public List<object> Architectural_Mechanisms { get; set; }

        [_XString("List and briefly describe the key abstractions of the system. This should be a relatively short list of the critical concepts that define the system. The key abstractions will usually translate to the initial analysis classes and important patterns.")]
        public object Key_abstractions { get; set; }

        [_XString("Describe the architectural pattern that you will use or how the architecture will be consistent and uniform. This could be a simple reference to an existing or well-known architectural pattern, such as the Layer framework, a reference to a high-level model of the framework, or a description of how the major system components should be put together.")]
        public object Layers_or_architectural_framework { get; set; }

        [_XString("Describe the architectural views that you will use to describe the software architecture. This illustrates the different perspectives that you will make available to review and to document architectural decisions.")]
        public Dictionary<string, object> Architectural_views { get; set; }
    }
}
