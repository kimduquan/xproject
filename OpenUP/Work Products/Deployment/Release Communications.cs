using _XSystem;
using OpenUP.Roles.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Deployment_Engineer))]
    [_XString("This artifact provides information to concerned parties that a product (or subset) has been placed into production.")]
    public class Release_Communications
    {
        public Deployment_Engineer Responsible { get; set; }
    }
}
