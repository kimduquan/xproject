using Microsoft.AspNetCore.SignalR;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace XWebApplication.XSystem.XObject
{
    public class XObjectHub : Hub
    {
        public Task XSetField(string ns, string t, int hashCode, string field)
        {
            string group = ns.Replace(".", "-") + "/" + t + "/" + hashCode;
            return Clients.Groups(ns).SendAsync("XSetField", ns, t, field);
        }

        public Task XInvokeMethod(string ns, string t, int hashCode, string method, string[] paramTypes)
        {
            string group = ns.Replace(".", "-") + "/" + t + "/" + hashCode;
            return Clients.Groups(ns).SendAsync("XInvokeMethod", ns, t, method, paramTypes);
        }

        public async Task AddToGroup(string ns, string t, int hashCode)
        {
            string group = ns.Replace(".", "-") + "/" + t + "/" + hashCode;
            await Groups.AddToGroupAsync(Context.ConnectionId, group);
        }

        public async Task RemoveFromGroup(string ns, string t, int hashCode)
        {
            string group = ns.Replace(".", "-") + "/" + t + "/" + hashCode;
            await Groups.RemoveFromGroupAsync(Context.ConnectionId, group);
        }
    }
}
