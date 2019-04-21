namespace OpenUP.Guidance.Checklists
{
    class Test_Case : Checklist
    {
        public Test_Case() : base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("General"),
                new Checkitem("Name"),
                new Checkitem("Brief Description"),
                new Checkitem("Test Data Needs")
            };
        }
    }
}
