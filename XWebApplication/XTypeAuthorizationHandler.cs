using _XSystem;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.Filters;
using System;
using System.Security.Claims;
using System.Threading.Tasks;
using XSystem;

namespace XWebApplication
{
    public class XTypeAuthorizationHandler : AuthorizationHandler<XTypeAuthorizationRequirement>
    {
        protected override Task HandleRequirementAsync(AuthorizationHandlerContext context, XTypeAuthorizationRequirement requirement)
        {
            bool success = false;
            if (context.User != null && context.Resource is AuthorizationFilterContext authContext && authContext.ModelState.IsValid)
            {
                XType xtype = null;
                XUtil.XFromRoute(out xtype, authContext.RouteData);
                XType xthis = null;
                if(context.User.HasClaim(c => c.Type == "Type"))
                {
                    Claim t = context.User.FindFirst(c => c.Type == "Type");
                    XUtil.XFromName(t.Value, out xthis);
                }
                if (xtype != null && xthis != null)
                {
                    if (xtype.XEqual(xthis))
                        success = true;
                    if(success == false)
                    {
                        foreach (XObject attr in xthis.XGetCustomAttributes())
                        {
                            if (attr.X is _XType xattr)
                            {
                                if (xattr.XType.FullName == xtype.XFullName)
                                {
                                    success = true;
                                    break;
                                }
                            }
                        }
                    }
                    if(success == false)
                    {
                        foreach (XObject attr in xtype.XGetCustomAttributes())
                        {
                            if (attr.X is _XType xattr)
                            {
                                if (xattr.XType.FullName == xthis.XFullName)
                                {
                                    success = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(success)
                context.Succeed(requirement);
            return Task.CompletedTask;
        }
    }
}
