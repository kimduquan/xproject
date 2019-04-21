namespace OpenUP.Guidance.Checklists
{
    class Work_Items_List: Checklist
    {
        public Work_Items_List() : base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("Have Work Items been described without ambiguity?"),
                new Checkitem("Have Work Items been prioritized?"),
                new Checkitem("Have Work Items been estimated?"),
                new Checkitem("Are the Work Items being tracked?"),
                new Checkitem("Are scheduled Work Items the right size?")
            };
        }
    }
}
