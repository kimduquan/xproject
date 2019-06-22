using System.Collections.Generic;
using System.Security.Claims;
using XSystem;

namespace XWebApplication.Models.XSystem
{
    public class _XObjectModel : _XModel
    {
        public _XObjectModel(_XThisModel xthis) : base(xthis)
        {

        }

        public static string XToHref(XObject xobject)
        {
            return "";
        }

        public static string XToString(XObject xobject)
        {
            return "";
        }

        public static List<Claim> XToClaims(XObject xobject)
        {
            List<Claim> claims = new List<Claim>()
            {
                new Claim(ClaimTypes.Name, xobject.XToString()),
                new Claim("Type", xobject.XGetType().XFullName),
                new Claim("hashCode", "" + xobject.XGetHashCode())
            };
            return claims;
        }
    }
}
