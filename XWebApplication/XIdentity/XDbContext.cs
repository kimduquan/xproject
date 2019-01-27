using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using XSystem;

namespace XWebApplication.XIdentity
{
    public class XDbContext : IdentityDbContext<XUser, XRole, XObject>
    {
    }
}
