namespace OpenUP.Guidance.Checklists
{
    class Developer_Test : Checklist
    {
        public Developer_Test():base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("The test coverage is acceptable"),
                new Checkitem("Developer test names or IDs are consistent with project naming conventions"),
                new Checkitem("The test logic is correct"),
                new Checkitem("Branch coverage is acceptable."),
                new Checkitem("The test is easy to maintain.")
            };
        }
    }
}
