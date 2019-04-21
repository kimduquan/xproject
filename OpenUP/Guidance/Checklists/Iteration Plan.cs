namespace OpenUP.Guidance.Checklists
{
    class Iteration_Plan : Checklist
    {
        public Iteration_Plan() : base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("Have you elaborated on the plan with the team?"),
                new Checkitem("Are iteration objectives clear?"),
                new Checkitem("Have key milestones for the iteration been identified ?"),
                new Checkitem("Do the team members feel confident about their Work Item assignments ?")
            };
        }
    }
}
