namespace OpenUP.Guidance.Checklists
{
    class Use_Case_Model: Checklist
    {
        public Use_Case_Model() : base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("It is easy to understand what the system does by reviewing the model"),
                new Checkitem("All use cases have been identified"),
                new Checkitem("The model is consistent"),
                new Checkitem("All relationships between use cases are required"),
                new Checkitem("Use-case packages are used appropriately"),
                new Checkitem("All model elements have appropriate names"),
                new Checkitem("Individual use cases are properly specified")
            };
        }
    }
}
