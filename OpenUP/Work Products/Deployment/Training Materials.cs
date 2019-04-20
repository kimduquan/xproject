using _XSystem;
using OpenUP.Roles.Deployment;
using OpenUP.Tasks.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Course_Developer))]
    public class Training_Materials
    {
        public Course_Developer Responsible { get; set; }
        public Course_Developer Modified_By { get; set; }
        public Develop_Training_Materials Output_From { get; set; }
    }
}
