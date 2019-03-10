using Microsoft.AspNetCore.Routing;
using System;
using System.Collections.Generic;
using XSystem;
using XSystem.XInternal;
using XSystem.XReflection;
using XSystem.XReflection.XInternal;

namespace XWebApplication
{
    public class Util
    {
        private static X x = null;

        public static X X
        {
            get
            {
                if (x == null)
                {
                    x = new XInternal();
                }
                return x;
            }
        }

        public static XType XFromRoute(RouteData data)
        {
            string dll = (string)data.Values["assembly"];
            string ns = (string)data.Values["namespace"];
            ns = ns.Replace('-', '.');
            string t = (string)data.Values["type"];
            XType xtype = X.XGetType(dll + "." + ns + "." + t);
            return xtype;
        }

        public static string XToRoute(XType xtype)
        {
            string[] path = xtype.XFullName.Split(".");
            string dll = path[0];
            string[] ns = new string[path.Length - 2];
            string name = path[path.Length - 1];
            string route = "/" + path[0];
            List<String> temp = new List<String>(path);
            temp.CopyTo(1, ns, 0, path.Length - 2);
            if(ns.Length > 0)
            {
                route = "/" + dll + "/" + string.Join('-', ns) + "/" + name;
            }
            else
            {
                route = "/" + dll + "/" + name;
            }
            return route;
        }

        public static XAssembly XGetAssembly(XType xtype)
        {
            return new XAssemblyInternal(xtype.X.Assembly, X);
        }
    }
}
