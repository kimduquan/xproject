namespace OpenUP.Guidance.Checklists
{
    class Deployment_Plan : Checklist
    {
        public Deployment_Plan():base()
        {
            checkItems = new Checkitem[] 
            {
                new Checkitem("Who are the end users of the features to be released?"),
                new Checkitem("What features must be deployed?"),
                new Checkitem("When do the features need to be available?"),
                new Checkitem("Where are the end users located?"),
                new Checkitem("Why is the release taking place?"),
                new Checkitem("Who will support the release after it is deployed?"),
                new Checkitem("When is the release \"done\"?")
            };
        }
    }
}
