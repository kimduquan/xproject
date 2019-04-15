using OpenUP.Roles.Basic_Roles;

namespace OpenUP
{
    public class OpenUP
    {
        public static object SignIn(string username, string password)
        {
            return new Developer();
        }

        public static object SignIn2(string username, string password)
        {
            return new Developer();
        }
    }
}
