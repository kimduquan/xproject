namespace OpenUP.Guidance.Checklists
{
    class Test_Data : Checklist
    {
        public Test_Data() : base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("Test data has been provided for the test cases to be implemented"),
                new Checkitem("The test data supports boundary testing"),
                new Checkitem("The system under test has been tested under conditions with sufficient data, insufficient data, and the wrong type of data"),
                new Checkitem("The test data is organized into production and generated data"),
                new Checkitem("The test data has been updated to apply to the appropriate iteration"),
                new Checkitem("The test data is complete for the given test effort"),
                new Checkitem("Data has been identified for input numeric variables, output numeric variables, arrays, and vectors")
            };
        }
    }
}
