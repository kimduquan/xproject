﻿using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Tasks.Requirements
{
    [_XType(typeof(Analyst))]
    [_XString("Define the vision for the future system. Describe the problem and features based on stakeholder requests.")]
    public class Develop_Technical_Vision
    {
        [_XType(typeof(Architect))]
        [_XType(typeof(Project_Manager))]
        [_XType(typeof(Stakeholder))]
        public Develop_Technical_Vision()
        {

        }
    }
}
