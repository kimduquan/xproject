using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Caching.Memory;
using System.Collections.Generic;
using XSystem;
using XWebApplication.Util;

namespace XWebApplication.Models
{
    public class _XThisModel
    {
        public _XObjectCache XCache { get; }

        public _XThisModel(IMemoryCache cache, ISession session)
        {
            XCache = _XObjectCache.XFromSession(session, cache);
        }
    }
}
