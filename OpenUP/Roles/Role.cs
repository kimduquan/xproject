using OpenUP.Tasks;
using OpenUP.Work_Products;

namespace OpenUP.Roles
{
    public abstract class Role
    {
        public abstract Task[] Additionally_Performs { get; }
        public abstract Artifact[] Modifies { get; }
    }
}
