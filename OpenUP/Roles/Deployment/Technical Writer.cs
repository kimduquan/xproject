using OpenUP.Work_Products.Deployment;

namespace OpenUP.Roles.Deployment
{
    public interface Technical_Writer
    {
        Product_Documentation Develop_Product_Documentation();

        User_Documentation Develop_User_Documentation(
            Product_Documentation product_Documentation = null
            );

        Support_Documentation Develop_Support_Documentation(
            Product_Documentation product_Documentation = null, 
            User_Documentation user_Documentation = null
            );
    }
}
