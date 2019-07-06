using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.Extensions.Caching.Memory;
using System.Collections.Generic;
using System.Threading.Tasks;
using XSystem;
using XSystem.XReflection;
using XWebApplication.Models;
using XWebApplication.Models.XSystem;
using XWebApplication.Util;

namespace XWebApplication.Auth
{
    public class XConstructorInfoAuthorizationHandler : AuthorizationHandler<XConstructorInfoAuthorizationRequirement>
    {
        private IMemoryCache cache = null;
        private X x = null;
        public XConstructorInfoAuthorizationHandler(IMemoryCache c, X xx)
        {
            cache = c;
            x = xx;
        }

        protected override Task HandleRequirementAsync(AuthorizationHandlerContext context, XConstructorInfoAuthorizationRequirement requirement)
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
                        List<XType> xtypes = _XTypeModel.XFromQuery(authContext.HttpContext.Request.Query, x);
                        XConstructorInfo xconstructor = xtype.XGetConstructor(xtypes.ToArray());
                        if(xconstructor != null)
                        {
                            success = _XThisModel.XAuthorize(xthis.XThis.XGetType(), xconstructor);
                        }
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
