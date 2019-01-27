using Microsoft.AspNetCore.SignalR;
using System.Threading.Tasks;

namespace XWebApplication.SignalR
{
    public class XTypeHub : Hub
    {
        public Task XSetField(string ns, string t, string field)
        {
            string group = ns.Replace(".", "-") + t;
            return Clients.Groups(ns).SendAsync("XSetField", ns, t, field);
        }

        public Task XInvokeMethod(string ns, string t, string method, string[] paramTypes)
        {
            string group = ns.Replace(".", "-") + "/" + t;
            return Clients.Groups(ns).SendAsync("XInvokeMethod", ns, t, method, paramTypes);
        }

        public async Task AddToGroup(string ns, string t)
        {
            string group = ns.Replace(".", "-") + "/" + t;
            await Groups.AddToGroupAsync(Context.ConnectionId, group);
        }

        public async Task RemoveFromGroup(string ns, string t)
        {
            string group = ns.Replace(".", "-") + "/" + t;
            await Groups.RemoveFromGroupAsync(Context.ConnectionId, group);
        }

    }
}
