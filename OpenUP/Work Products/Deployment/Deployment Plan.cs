using OpenUP.Roles.Deployment;
using OpenUP.Tasks.Deployment;

namespace OpenUP.Work_Products.Deployment
{
    public class Deployment_Plan
    {
        public Deployment_Engineer Responsible { get; set; }
        public Deployment_Engineer Modified_By { get; set; }
        public Plan_Deployment Output_From { get; set; }
    }
}
