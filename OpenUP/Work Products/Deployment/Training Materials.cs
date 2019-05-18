using _XSystem;
using OpenUP.Roles.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Course_Developer))]
    [_XString("This work product represents all the materials needed to train end users and production support personnel on the features and inner workings of a product for a particular release.")]
    public class Training_Materials
    {
        public Course_Developer Responsible { get; set; }
    }
}
