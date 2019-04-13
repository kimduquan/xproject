using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Pages
{
    public class XTypeUtil
    {
        public void Bind(PageModel model)
        {
            
        }

        public void OnPost(PageModel model)
        {

        }

        public void OnGet(PageModel model)
        {

        }

        public JsonResult OnGetArray(PageModel model)
        {
            return null;
        }

        public IEnumerator<string> XGetStaticMethodsHRef()
        {
            return null;
        }

        public IEnumerator<string> XGetStaticMethodsName()
        {
            return null;
        }

        public XType XType
        {
            get;
        }

        public XAssembly XAssembly
        {
            get;
        }
    }
}
