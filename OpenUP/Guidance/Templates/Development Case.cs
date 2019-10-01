using _XSystem;
using OpenUP.Work_Products;
using OpenUP.Work_Products.Project_Management;
using OpenUP.Work_Products.Requirements;
using System.Collections.Generic;

namespace OpenUP.Guidance.Templates
{
    [_XString("This is a template for the tailored process that a project is to follow in order to produce the project's desired results.")]
    public struct Development_Case : Template
    {
        public string Project_Name { get; set; }

        [_XString("The introduction of the Development Case provides an overview of the entire document. It includes the purpose, scope, definitions, acronyms, abbreviations, references, and overview of this Development Case.")]
        public object Introduction { get; set; }

        [_XString("Specify the purpose of this Development Case.")]
        public object Purpose { get; set; }

        [_XString("A brief description of the scope of this Development Case; what Project(s) it is associated with and anything else that is affected or influenced by this document.")]
        public object Scope { get; set; }

        [_XString("This subsection provides the definitions of all terms, acronyms, and abbreviations required to properly interpret the Development Case. This information may be provided by reference to the project's Glossary.")]
        public Glossary Definitions_Acronyms_and_Abbreviations { get; set; }

        [_XString(@"This section is optional. Alternatively to having an explicit references section using the table below, write down the full name of the document you are referring to in-line with the text where if first appears, then add a hyperlink to the location where the referenced element is stored, and add a acronym (between parenthesis) right after the first appearance of that reference. On subsequent appearances of that reference, use the acronym only.
If you use this section, provide a complete list of all documents referenced elsewhere in the Development Case.Identify each document by title, report number(if applicable), date, and publishing organization.Specify the sources from which the references can be obtained.This information may be provided by reference to an appendix or to another document.
NOTE: Be sure to include a reference to the version of the organizational process this development case is based on.")]
        public List<Reference> References { get; set; }

        [_XString("This subsection describes what the rest of the Development Case contains and explains how the document is organized.")]
        public object Overview { get; set; }

        [_XString("Briefly describe the lifecycle model employed by the project including descriptions of the milestones and their purpose. The purpose is to serve as an introduction to the rest of the development case, not to be a project plan.")]
        public object Lifecycle_Model { get; set; }

        [_XString(@"This section is optional. Include sample iteration plans if they will be helpful for your project.
Your organizational process captured in Method Composer may provide capability patterns that can serve as templates for phase iteration plans.Your organization may have included a delivery process in your published version of the organizational process that can serve as a basis for your iteration plans.
If you are using a separate project management tool to create project plans, this section is not needed.")]
        public object Sample_Iteration_Plans { get; set; }

        public List<Iteration_Plan> Inception_Phase { get; set; }

        [_XString("Describe any changes made to the standard workflow for this phase. Typical changes include adding or removing activities or tasks to describe project-specific ways of working.")]
        public object Notes_on_Inception_Phase_Workflow { get; set; }
        public List<Iteration_Plan> Elaboration_Phase { get; set; }

        [_XString("Describe any changes made to the standard workflow for this phase. Typical changes include adding or removing activities or tasks to describe project-specific ways of working.")]
        public object Notes_on_Elaboration_Phase_Workflow { get; set; }
        public List<Iteration_Plan> Construction_Phase { get; set; }

        [_XString("Describe any changes made to the standard workflow for this phase. Typical changes include adding or removing activities or tasks to describe project-specific ways of working.")]
        public object Notes_on_Construction_Phase_Workflow { get; set; }
        public List<Iteration_Plan> Transition_Phase { get; set; }

        [_XString("Describe any changes made to the standard workflow for this phase. Typical changes include adding or removing activities or tasks to describe project-specific ways of working.")]
        public object Notes_on_Transition_Phase_Workflow { get; set; }

        [_XString("A work product is an artifact, outcome, or deliverable. Provide a list of work products to be produced for the project, when the work product is created and completed, along with details of how the work product is reviewed (when appropriate), who reviews and approves the work product (RACI responsibility matrix) what template is used to create the work product, where the work product is kept or what tool is used to manage it. This can be accomplished by embedding a work product addendum to the development case, such as in spreadsheet format. Alternatively, you may use another method to provide the list of work products, either in this document or as an addendum to this document.")]
        public List<Artifact> Work_Products { get; set; }

        [_XString("List any reports that are useful for this project. Describe who uses the report and how it can be created.")]
        public List<_Report> Reports { get; set; }

        public List<_Role> Roles { get; set; }

        [_XString("Identify any guidelines and procedures used by the project that are not included in the organizational process. These should include any special review procedures, style or coding guidelines, etc. Modify the suggested table to fit your needs.")]
        public List<_Guideline_or_Procedure> Project_Specific_Guidelines_and_Procedures { get; set; }

        public struct Reference
        {
            public string Reference_Name { get; set; }
            public object Owner_Author { get; set; }
            public object Where_Stored { get; set; }
        }
        public struct _Report
        { 
            public object Report { get; set; }
            public object Audience { get; set; }
            public object How_Created_Where_Stored { get; set; }
        }

        public struct _Role
        {
            [_XString("Identify the roles used on your project. For example, it is common to refine the role stakeholder into more than one role. You might need to add new roles or clarify how each role is used in the organization by providing role names commonly used in your organization")]
            public object Role { get; set; }

            [_XString("Y if this is a role identified in the organizational process; N if it is not defined in the process.")]
            public object Process_Role { get; set; }

            [_XString("Use this column to map job positions in the organization to the roles in the organizational process.")]
            public object Applicability { get; set; }

            [_XString("Describe any differences in responsibilities in the organization from those described in the process.]")]
            public object Responsibilities_Different_from_Process { get; set; }

        }

        public struct _Guideline_or_Procedure
        {
            public object Guideline_or_Procedure { get; set; }
            public object Owner { get; set; }

            public object Used_by { get; set; }

            public object Where_Stored { get; set; }
        }
    }
}
