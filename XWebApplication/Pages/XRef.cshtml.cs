using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using XSystem;

namespace XWebApplication.Pages
{
    public class XRefModel : PageModel
    {
        public void OnGet()
        {
        }

        public XType xtype { get; set; }
    }
}