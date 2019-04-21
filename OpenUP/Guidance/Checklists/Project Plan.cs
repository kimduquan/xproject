namespace OpenUP.Guidance.Checklists
{
    class Project_Plan : Checklist
    {
        public Project_Plan() : base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("Has the plan been elaborated with the team?"),
                new Checkitem("Has the team agreed on development practices for the project?"),
                new Checkitem("Have the project milestones been defined ?"),
                new Checkitem("Has the deployment strategy been discussed ?")
            };
        }
    }
}
