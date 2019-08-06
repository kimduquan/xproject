using _XSystem;
using OpenUP.Roles;

namespace OpenUP.Work_Products
{
    public abstract class Artifact
    {
        public Artifact([_XThis] Role responsible, Work_Product_Slot fulfilledSlots)
        {
            Responsible = responsible;
            Fulfilled_Slots = fulfilledSlots;
        }
        public Role Responsible { get; }
        public Work_Product_Slot Fulfilled_Slots { get; }
        public abstract Role[] Modified_By { get; }
    }
}
