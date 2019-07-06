using _XSystem;
using OpenUP.Work_Products.Project_Management;
using OpenUP.Work_Products.Requirements;

namespace OpenUP.Roles.Basic_Roles
{
    [_XType(typeof(Glossary))]
    [_XType(typeof(System_Wide_Requirements))]
    [_XType(typeof(Use_Case))]
    [_XType(typeof(Use_Case_Model))]
    [_XType(typeof(Vision))]
    [_XType(typeof(Work_Items_List))]
    [_XString("The person in this role represents customer and end-user concerns by gathering input from stakeholders to understand the problem to be solved and by capturing and setting priorities for requirements.")]
    public class Analyst : Any_Role
    {
    }
}
