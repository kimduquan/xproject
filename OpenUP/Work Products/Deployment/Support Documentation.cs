using _XSystem;
using OpenUP.Roles.Deployment;
using OpenUP.Tasks.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    [_XType(typeof(Technical_Writer))]
    public class Support_Documentation
    {
        public Technical_Writer Responsible { get; set; }
        public Technical_Writer Modified_By { get; set; }
        public Develop_Support_Documentation Output_From { get; set; }
    }
}
