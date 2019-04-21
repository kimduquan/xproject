namespace OpenUP.Guidance.Checklists
{
    class Implementation : Checklist
    {
        public Implementation() : base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("The implementation conforms to the architecture and design"),
                new Checkitem("The implementation is testable"),
                new Checkitem("The implementation is correct"),
                new Checkitem("The implementation is understandable"),
                new Checkitem("There is no redundancy")
            };
        }
    }
}
