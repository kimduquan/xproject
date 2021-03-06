﻿using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Tasks.Project_Management
{
    [_XType(typeof(Project_Manager))]
    [_XString("A collaborative task that outlines an initial agreement on how the project will achieve its goals. The resulting project plan provides a summary-level overview of the project.")]
    public class Plan_Project
    {
        [_XType(typeof(Analyst))]
        [_XType(typeof(Architect))]
        [_XType(typeof(Developer))]
        [_XType(typeof(Stakeholder))]
        [_XType(typeof(Tester))]
        public Plan_Project()
        {

        }
    }
}
