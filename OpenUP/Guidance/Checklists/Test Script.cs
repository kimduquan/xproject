namespace OpenUP.Guidance.Checklists
{
    class Test_Script: Checklist
    {
        public Test_Script() : base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("The test script conforms to the related test case"),
                new Checkitem("The test script is testable"),
                new Checkitem("The test script is reusable"),
                new Checkitem("The test script is prescriptive and unambiguous"),
                new Checkitem("The test script is named consistently with the other test work products"),
                new Checkitem("The test script provides appropriate test coverage")
            };
        }
    }
}
