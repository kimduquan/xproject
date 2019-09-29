using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Caching.Memory;
using Microsoft.Extensions.Localization;
using System.Collections.Generic;
using System.Threading.Tasks;
using XSystem;
using XWebApplication.Models;
using XWebApplication.Models.XSystem;

namespace XWebApplication.Controllers
{
    [Route("/_/")]
    [ApiController]
    public class XController : ControllerBase
    {
        private X x = null;
        private IMemoryCache cache = null;
        IStringLocalizerFactory factory = null;

        public XController(X xx, IMemoryCache c, IStringLocalizerFactory f)
        {
            x = xx;
            cache = c;
            factory = f;
        }

        [HttpGet("typeof")]
        public async Task<ActionResult<XType>> XTypeOf([FromQuery] string type)
        {
            XType xtype = _XTypeModel.XFromFullName(type, x);
            return Ok(xtype);
        }

        [HttpGet("object")]
        public async Task<ActionResult<XObject>> XObject([FromQuery] string key)
        {
            _XThisCache xthis = _XThisModel.XFromCache(cache, HttpContext.Session);
            XObject xobject = _XObjectModel.XFromCache(xthis, key);
            return Ok(xobject);
        }

        [HttpGet("params")]
        public async Task<ActionResult<XObject[]>> XParams([FromQuery] string key, [FromQuery] int? index, [FromQuery] int? count)
        {
            _XThisCache xthis = _XThisModel.XFromCache(cache, HttpContext.Session);
            List<XObject> xparams = null;
            _XParamsModel.XFromCache(xthis, key, out xparams, index, count);
            return Ok(xparams.ToArray());
        }

        [HttpPost("params")]
        public async Task<ActionResult<bool>> XParams([FromForm] string key, [FromForm] string objectKey)
        {
            _XThisCache xthis = _XThisModel.XFromCache(cache, HttpContext.Session);
            bool res = _XParamsModel.XToCache(xthis, key, objectKey);
            return Ok(res);
        }

        [HttpPost("string")]
        public async Task<ActionResult> XString([FromQuery] string lang)
        {
            _XThisCache xthis = _XThisModel.XFromCache(cache, HttpContext.Session);
            return Ok();
        }

        [HttpPost("await")]
        public async Task<ActionResult> XAwait([FromQuery] string type, int hashCode)
        {
            _XThisCache xthis = _XThisModel.XFromCache(cache, HttpContext.Session);
            return Ok();
        }
    }
}
