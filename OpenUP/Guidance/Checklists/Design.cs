namespace OpenUP.Guidance.Checklists
{
    class Design : Checklist
    {
        public Design():base()
        {
            checkItems = new Checkitem[]
            {
                new Checkitem("The design is understandable"),
                new Checkitem("The design is consistent"),
                new Checkitem("The design is maintainable"),
                new Checkitem("The design is traceable"),
                new Checkitem("The design reflects the architectural objectives of the system"),
                new Checkitem("The design elements are modular"),
                new Checkitem("The system can be implemented from the information in the design"),
                new Checkitem("The design provide enough information for developer testing"),
                new Checkitem("The design describe the system at the appropriate level of abstraction"),
                new Checkitem("The design supports a coarse - grained perspective of the system"),
                new Checkitem("Packages and Organization"),
                new Checkitem("Views"),
                new Checkitem("UML"),
                new Checkitem("Non - UML Visual Modeling"),
            };
        }
    }
}
