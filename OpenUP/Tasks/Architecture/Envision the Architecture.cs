﻿using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP.Tasks.Architecture
{
    [_XType(typeof(Architect))]
    [_XString("This task is where the \"vision\" for the architecture is developed through analysis of the architecturally significant requirements and identification of architectural constraints, decisions and objectives.")]
    public class Envision_the_Architecture
    {
        [_XType(typeof(Analyst))]
        [_XType(typeof(Developer))]
        [_XType(typeof(Project_Manager))]
        [_XType(typeof(Stakeholder))]
        public Envision_the_Architecture()
        {

        }
    }
}
