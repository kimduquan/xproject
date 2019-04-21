namespace OpenUP.Guidance.Checklists
{
    class System_Wide_Requirements : Checklist
    {
        public System_Wide_Requirements() : base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("Global functional requirements have been captured and validated"),
                new Checkitem("Usability requirements have been captured and validated"),
                new Checkitem("Reliability requirements have been captured and validated"),
                new Checkitem("Performance requirements have been captured and validated"),
                new Checkitem("Supportability requirements have been captured and validated"),
                new Checkitem("Constraints have been captured and validated"),
                new Checkitem("External interfaces have been identified"),
                new Checkitem("Business rules have been captured and validated"),
                new Checkitem("Applicable standards and regulatory compliance requirements have been identified")
            };
        }
    }
}
