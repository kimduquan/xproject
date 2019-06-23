using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.Filters;
using System.Threading.Tasks;

namespace XWebApplication.Auth
{
    public class XTypeAuthorizationHandler : AuthorizationHandler<XTypeAuthorizationRequirement>
    {
        protected override Task HandleRequirementAsync(AuthorizationHandlerContext context, XTypeAuthorizationRequirement requirement)
        {
            bool success = false;
            if (context.User != null && context.Resource is AuthorizationFilterContext authContext && authContext.ModelState.IsValid)
            {
                XUtil.XAuthorize(authContext.RouteData, context.User, out success);
             }
            if(success)
            {
                context.Succeed(requirement);
            }
            return Task.CompletedTask;
        }
    }
}
