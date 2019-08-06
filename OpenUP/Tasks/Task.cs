using _XSystem;
using OpenUP.Roles;

namespace OpenUP.Tasks
{
    public abstract class Task
    {
        public Task([_XThis] Role primaryPerformer)
        {
            Primary_Performer = primaryPerformer;
        }
        public Role Primary_Performer { get; }
        public abstract Role[] Additional_Performers { get; }
    }
}
