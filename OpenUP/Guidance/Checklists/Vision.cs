namespace OpenUP.Guidance.Checklists
{
    class Vision: Checklist
    {
        public Vision() : base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("The problem behind the problem has been fully explored"),
                new Checkitem("The problem statement is correctly formulated"),
                new Checkitem("The list of stakeholders is complete and correct"),
                new Checkitem("Everyone agrees on the definition of the system boundaries"),
                new Checkitem("Constraints on the system have been sufficiently explored"),
                new Checkitem("All kinds of constraints, including political, economic, and environmental, have been covered."),
                new Checkitem("All key features of the system been identified and defined"),
                new Checkitem("The features solve the identified problems"),
                new Checkitem("The features are consistent with the identified constraints"),
                new Checkitem("Someone unfamiliar with the project can understand the project objectives")
            };
        }
    }
}
