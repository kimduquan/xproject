using _XSystem;
using OpenUP.Roles.Basic_Roles;
using System;

namespace OpenUP
{
    public class OpenUP
    {
        public static Any_Role SignIn(string username, [_XImplicit] string password)
        {
            if(username == "")
            {
                throw new Exception("user name is empty!");
            }
            else if (username == "analyst")
                return new Analyst();
            else if (username == "architect")
                return new Architect();
            else if (username == "developer")
                return new Developer();
            else if (username == "project manager")
                return new Project_Manager();
            else if (username == "stakeholder")
                return new Stakeholder();
            else if (username == "tester")
                return new Tester();
            return null;
        }

        /*public static Project_Manager SignInAsProjectManager(string username, [_XImplicit] string password)
        {
            return new Project_Manager();
        }*/
    }
}
