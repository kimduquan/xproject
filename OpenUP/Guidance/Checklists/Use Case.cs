namespace OpenUP.Guidance.Checklists
{
    class Use_Case : Checklist
    {
        public Use_Case() : base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("The use-case name is meaningful and un-ambiguous"),
                new Checkitem("The brief description clearly describes the primary goal of the use case  "),
                new Checkitem("Associated actors and information exchanged are clearly defined"),
                new Checkitem("Pre-conditions have been specified"),
                new Checkitem("The Basic Flow and Alternate Flows are complete, correct and consistent"),
                new Checkitem("Post-conditions have been specified"),
                new Checkitem("Applicable non-functional requirements have been captured")
            };
        }
    }
}
