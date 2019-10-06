using _XSystem;
using OpenUP.Roles.Basic_Roles;
using System;

namespace OpenUP
{
    public class OpenUP
    {
        public static Any_Role SignIn(string userName, [_XImplicit] string pass_word)
        {
            if(userName == "")
            {
                throw new Exception("user name is empty!");
            }
            else if (userName == "analyst")
                return new Analyst();
            else if (userName == "architect")
                return new Architect();
            else if (userName == "developer")
                return new Developer();
            else if (userName == "project manager")
                return new Project_Manager();
            else if (userName == "stakeholder")
                return new Stakeholder();
            else if (userName == "tester")
                return new Tester();
            return null;
        }

        /*public static Project_Manager SignInAsProjectManager(string username, [_XImplicit] string password)
        {
            return new Project_Manager();
        }*/
    }
}
