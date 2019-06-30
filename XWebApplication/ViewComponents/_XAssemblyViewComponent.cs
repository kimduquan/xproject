using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Threading.Tasks;
using XSystem;
using XSystem.XReflection;
using XWebApplication.Models;
using XWebApplication.Models.XSystem.XReflection;
using XWebApplication.Util;

namespace XWebApplication.ViewComponents
{
    public class _XAssemblyViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(XAssembly xassembly, _XThisCache xthis)
        {
            _XAssemblyModel xmodel = new _XAssemblyModel();
            XType xtype = xthis.XThis.XGetType();
            List<XType> xtypes = _XThisModel.XAuthorize(xtype, xassembly.XExportedTypes);
            Dictionary<string, List<string>> childNSs;
            Dictionary<string, List<XType>> childTypes;
            XToHiearchyTypes(xtypes, out childNSs, out childTypes);
            xmodel.XNamespaces = childNSs;
            xmodel.XTypes = childTypes;
            xmodel.XInformation = _XAssemblyModel.XToAbout(xassembly);
            return View(xmodel);
        }

        protected static void XToHiearchyTypes(List<XType> xtypes, out Dictionary<string, List<string>> childNSs, out Dictionary<string, List<XType>> childTypes)
        {
            childNSs = new Dictionary<string, List<string>>();
            childTypes = new Dictionary<string, List<XType>>();
            using (IEnumerator<XType> it = xtypes.GetEnumerator())
            {
                while (it.MoveNext())
                {
                    if (childTypes.ContainsKey(it.Current.XNamespace))
                    {
                        childTypes[it.Current.XNamespace].Add(it.Current);
                    }
                    else
                    {
                        List<XType> types = new List<XType>();
                        types.Add(it.Current);
                        childTypes[it.Current.XNamespace] = types;
                    }

                    string[] path = it.Current.XNamespace.Split(".");
                    string ns = "";
                    for (int i = 0; i < path.Length - 1; i++)
                    {
                        if (ns.Equals(""))
                        {
                            ns += path[i];
                        }
                        else
                        {
                            ns += ("." + path[i]);
                        }
                        if (childNSs.ContainsKey(ns) == false)
                        {
                            childNSs[ns] = new List<string>();
                            childNSs[ns].Add(path[i + 1]);
                        }
                        else
                        {
                            bool needAdd = true;
                            foreach (string n in childNSs[ns])
                            {
                                if (n.Equals(path[i + 1]))
                                {
                                    needAdd = false;
                                    break;
                                }
                            }
                            if (needAdd)
                            {
                                childNSs[ns].Add(path[i + 1]);
                            }
                        }
                    }
                }
            }
        }
    }
}
