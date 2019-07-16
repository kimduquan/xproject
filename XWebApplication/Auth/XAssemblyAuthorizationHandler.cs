using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.Extensions.Caching.Memory;
using System.Threading.Tasks;
using XSystem;
using XSystem.XReflection;
using XWebApplication.Models;
using XWebApplication.Models.XSystem.XReflection;

namespace XWebApplication.Auth
{
    public class XAssemblyAuthorizationHandler : AuthorizationHandler<XAssemblyAuthorizationRequirement>
    {
        private IMemoryCache cache = null;
        private X x = null;
        public XAssemblyAuthorizationHandler(IMemoryCache c, X xx)
        {
            cache = c;
            x = xx;
        }

        protected override Task HandleRequirementAsync(AuthorizationHandlerContext context, XAssemblyAuthorizationRequirement requirement)
        {
            bool success = false;
            if (context.User != null && context.Resource is AuthorizationFilterContext authContext && authContext.ModelState.IsValid)
            {
                XAssembly xassembly = _XAssemblyModel.XFromRoute(authContext.RouteData, x);
                if(xassembly != null)
                {
                    _XThisCache xthis = _XThisModel.XAuthenticate(context.User, cache, authContext.HttpContext.Session);
                    if(xthis != null)
                    {
                        success = _XThisModel.XAuthorize(xthis.XThis.XGetType(), xassembly);
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
