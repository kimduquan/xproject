namespace OpenUP.Guidance.Checklists
{
    class Checkitem
    {
        private string name;
        public Checkitem(string n)
        {
            name = n;
            Check = false;
        }

        public string Item { get { return name; } }
        public bool Check { get; set; }
    }
}
