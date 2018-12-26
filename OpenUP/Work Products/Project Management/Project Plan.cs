﻿using OpenUP.Roles.Basic_Roles;
using OpenUP.Tasks.Project_Management;

namespace OpenUP.Work_Products.Project_Management
{
    public class Project_Plan
    {
        public Project_Manager Responsible { get; set; }
        public Project_Manager Modified_By { get; set; }
        public Plan_Project Output_From { get; set; }
    }
}
