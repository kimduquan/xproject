

namespace OpenUP.Guidance.Checklists
{
    class Architecture_Notebook : Checklist
    {
        public Architecture_Notebook() : base()
        {
            checkItems = new Checkitem[] 
            {
                new Checkitem("Is the architecture understandable?"),
                new Checkitem("Have the architectural goals, constraints and requirements been adequately described and handled?"),
                new Checkitem("Have necessary architectural mechanisms been identified and described?"),
                new Checkitem("Have the system partitions been adequately defined?"),
                new Checkitem("Have the key elements been adequately defined?"),
                new Checkitem("Have interfaces to external systems been adequately represented?"),
                new Checkitem("Has all reuse been identified?"),
                new Checkitem("Has the architecture been built to evolve?"),
                new Checkitem("Can the architecture be delivered by the team?"),
                new Checkitem("Has the software been adequately mapped to the hardware?")
            };
        }
    }
}
