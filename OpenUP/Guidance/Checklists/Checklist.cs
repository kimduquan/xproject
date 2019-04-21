namespace OpenUP.Guidance.Checklists
{
    abstract class Checklist
    {
        protected Checkitem[] checkItems = null;
        private object[] relatedElements = null;

        public Checklist(params object[] elements)
        {
            relatedElements = elements;
        }

        public Checkitem[] CheckItems { get { return checkItems; } }
        public object[] RelatedElements { get { return relatedElements; } }
    }
}
