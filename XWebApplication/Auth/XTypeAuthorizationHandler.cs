using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.Extensions.Caching.Memory;
using System.Threading.Tasks;
using XSystem;
using XWebApplication.Models;
using XWebApplication.Models.XSystem;

namespace XWebApplication.Auth
{
    public class XTypeAuthorizationHandler : AuthorizationHandler<XTypeAuthorizationRequirement>
    {
        private IMemoryCache cache = null;
        private X x = null;
        public XTypeAuthorizationHandler(IMemoryCache c, X xx)
        {
            cache = c;
            x = xx;
        }

        protected override Task HandleRequirementAsync(AuthorizationHandlerContext context, XTypeAuthorizationRequirement requirement)
        {
            bool success = false;
            if (context.User != null && context.Resource is AuthorizationFilterContext authContext && authContext.ModelState.IsValid)
            {
                XType xtype = _XTypeModel.XFromRoute(authContext.RouteData, x);
                if(xtype != null)
                {
                    _XThisCache xthis = _XThisModel.XAuthenticate(context.User, cache, authContext.HttpContext.Session);
                    if(xthis != null)
                    {
                        success = _XThisModel.XAuthorize(xthis.XThis.XGetType(), xtype);
                    }
                }
             }
            if(success)
            {
                context.Succeed(requirement);
            }
            return Task.CompletedTask;
        }
    }
}
