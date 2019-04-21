namespace OpenUP.Guidance.Checklists
{
    class General_Requirements : Checklist
    {
        public General_Requirements() : base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("The requirement is correct"),
                new Checkitem("The requirement is complete"),
                new Checkitem("The requirement is clear"),
                new Checkitem("The requirement is consistent"),
                new Checkitem("The requirement is verifiable"),
                new Checkitem("The requirement is traceable"),
                new Checkitem("The requirement is feasible"),
                new Checkitem("The requirement is design independent"),
                new Checkitem("The requirement is atomic"),
            };
        }
    }
}
