using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.Extensions.Caching.Memory;
using System.Security.Claims;
using System.Threading.Tasks;
using XSystem;
using XWebApplication.Models;
using XWebApplication.Models.XSystem;
using XWebApplication.Util;

namespace XWebApplication.Auth
{
    public class XObjectAuthorizationHandler : AuthorizationHandler<XObjectAuthorizationRequirement>
    {
        private IMemoryCache cache = null;
        X x = null;

        public XObjectAuthorizationHandler(IMemoryCache memory, X xx)
        {
            cache = memory;
            x = xx;
        }
        protected override Task HandleRequirementAsync(AuthorizationHandlerContext context, XObjectAuthorizationRequirement requirement)
        {
            bool success = false;
            if (context.User != null && context.Resource is AuthorizationFilterContext authContext && authContext.ModelState.IsValid)
            {
                XType xtype = _XTypeModel.XFromRoute(authContext.RouteData, x);
                if (xtype != null)
                {
                    _XThisCache xthis = _XThisModel.XAuthenticate(context.User, cache, authContext.HttpContext.Session);
                    if (xthis != null)
                    {
                        XObject xobject = _XThisModel.XFromRoute(authContext.RouteData, xthis, x);
                        if (xobject != null && xthis != null)
                        {
                            success = true;
                        }
                    }
                }
            }
            if (success)
                context.Succeed(requirement);
            return Task.CompletedTask;
        }
    }
}
