using _XSystem;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Routing;
using Microsoft.Extensions.Caching.Memory;
using System.Collections.Generic;
using System.Security.Claims;
using XSystem;
using XSystem.XReflection;
using XWebApplication.Models.XSystem;
using XWebApplication.Util;

namespace XWebApplication.Models
{
    public class _XThisModel
    {
        public _XThisCache XCache { get; }

        public _XThisModel(_XThisCache xcache)
        {
            XCache = xcache;
        }

        public static void XToSession(XObject xthis, ISession session)
        {
            session.SetString("this", _XThisCache.XToKey(xthis));
        }

        public static void XToCache(XObject xthis, IMemoryCache cache, ISession session)
        {
            string key = session.GetString("this");
            _XThisCache xthisCache = new _XThisCache(xthis);
            using (ICacheEntry entry = cache.CreateEntry(key))
            {
                entry.SetValue(xthisCache);
            }
        }

        public static _XThisCache XFromCache(IMemoryCache cache, ISession session)
        {
            _XThisCache xthis = null;
            string key = session.GetString("this");
            cache.TryGetValue(key, out xthis);
            return xthis;
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

        public static _XThisCache XAuthenticate(ClaimsPrincipal user, IMemoryCache cache, ISession session)
        {
            _XThisCache xthis = null;
            if (user.HasClaim(c => c.Type == "Type") && user.HasClaim(c => c.Type == "hashCode"))
            {
                Claim t = user.FindFirst(c => c.Type == "Type");
                Claim h = user.FindFirst(c => c.Type == "hashCode");
                xthis = XFromCache(cache, session);
            }
            return xthis;
        }

        public static XObject XFromRoute(RouteData route, _XThisCache cache, X x)
        {
            XObject xobject = null;
            if(route.Values.ContainsKey("hashCode"))
            {
                object obj = null;
                route.Values.TryGetValue("hashCode", out obj);
                XType xtype = _XTypeModel.XFromRoute(route, x);
                if(obj is string szHashCode && xtype != null)
                {
                    int hashCode = 0;
                    if(int.TryParse(szHashCode, out hashCode))
                    {
                        xobject = cache.XObject(xtype, hashCode);
                    }
                }
            }
            return xobject;
        }

        public static List<XType> XAuthorize(XType xthis, IEnumerable<XType> xtypes)
        {
            List<XType> result = new List<XType>();
            using (IEnumerator<XType> it = xtypes.GetEnumerator())
            {
                while (it.MoveNext())
                {
                    if (it.Current.XIsPublic && it.Current.XIsAbstract == false)
                    {
                        bool success = false;
                        success = XAuthorize(xthis, it.Current);
                        if (success)
                            result.Add(it.Current);
                    }
                };
            }
            return result;
        }

        public static bool XAuthorize(XType xthis, XType xtype)
        {
            bool success = false;
            bool isCustom = false;
            if (xtype != null && xthis != null)
            {
                if (xtype.XEqual(xthis))
                {
                    success = false;
                }
                else
                {
                    success = _XTypeModel.XCheckXTypeAttribute(xthis, xtype, out isCustom);
                    if (isCustom == false || success == false)
                    {
                        success = _XTypeModel.XCheckXTypeAttribute(xtype, xthis, out isCustom);
                        if (isCustom == false)
                        {
                            success = true;
                        }
                    }
                }
            }
            return success;
        }

        public static bool XAuthorize(XType xthis, XConstructorInfo xconstructor)
        {
            bool success = false;
            bool isCustom = false;
            success = _XModel.XCheckXTypeAttribute(xthis, xconstructor.XGetCustomAttributes(), out isCustom);
            if (isCustom == false)
            {
                success = true;
            }
            return success;
        }
        
        public static bool XAuthorize(RouteData routeData, ClaimsPrincipal user, X x)
        {
            bool success = false;
            XType xtype = _XTypeModel.XFromRoute(routeData, x);
            XType xthis = _XTypeModel.XFromUser(user, x);
            success = XAuthorize(xthis, xtype);
            return success;
        }
    }
}
