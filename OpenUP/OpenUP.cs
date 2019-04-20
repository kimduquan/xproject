using _XSystem;
using OpenUP.Roles.Basic_Roles;

namespace OpenUP
{
    public class OpenUP
    {
        public static Any_Role SignIn(string username, [_XImplicit] string password)
        {
            return new Developer();
        }

        public static Project_Manager SignInAsProjectManager(string username, [_XImplicit] string password)
        {
            return new Project_Manager();
        }
    }
}
