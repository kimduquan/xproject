using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.Extensions.Caching.Memory;
using System.Security.Claims;
using System.Threading.Tasks;
using XSystem;

namespace XWebApplication.Auth
{
    public class XObjectAuthorizationHandler : AuthorizationHandler<XObjectAuthorizationRequirement>
    {
        private IMemoryCache cache = null;
        public XObjectAuthorizationHandler(IMemoryCache memory)
        {
            cache = memory;
        }
        protected override Task HandleRequirementAsync(AuthorizationHandlerContext context, XObjectAuthorizationRequirement requirement)
        {
            bool success = false;
            if (context.User != null && context.Resource is AuthorizationFilterContext authContext && authContext.ModelState.IsValid)
            {
                XObject xthis = null;
                if (context.User.HasClaim(c => c.Type == "Type") && context.User.HasClaim(c => c.Type == "hashCode"))
                {
                    Claim t = context.User.FindFirst(c => c.Type == "Type");
                    Claim h = context.User.FindFirst(c => c.Type == "hashCode");
                    XUtil.XFromCache(out xthis, cache, authContext.HttpContext.Session, t.Value, int.Parse(h.Value));
                }
                XType xtype = null;
                XUtil.XFromRoute(out xtype, authContext.RouteData);
                object hashCode = null;
                XObject xobject = null;
                authContext.RouteData.Values.TryGetValue("hashCode", out hashCode);
                XUtil.XFromCache(out xobject, cache, authContext.HttpContext.Session, xtype.XFullName, int.Parse((string)hashCode));
                if(xobject != null && xthis != null)
                {
                    success = true;
                }
            }
            if (success)
                context.Succeed(requirement);
            return Task.CompletedTask;
        }
    }
}
