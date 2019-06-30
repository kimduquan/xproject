﻿using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using XWebApplication.Models;
using XWebApplication.Util;

namespace XWebApplication.ViewComponents
{
    public class _XThisViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync(_XThisCache xthis)
        {
            return View(new _XThisModel(xthis));
        }
    }
}
