namespace OpenUP.Guidance.Checklists
{
    class Risk_List : Checklist
    {
        public Risk_List() : base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("Have all potential risks to the project been identified?"),
                new Checkitem("Have all risks been described without ambiguity?"),
                new Checkitem("Have all major risks been evaluated?"),
                new Checkitem("Are there interdependencies between risks?")
            };
        }
    }
}
