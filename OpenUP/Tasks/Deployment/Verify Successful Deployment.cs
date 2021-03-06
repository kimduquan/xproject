﻿using _XSystem;
using OpenUP.Roles.Basic_Roles;
using OpenUP.Roles.Deployment;

namespace OpenUP.Tasks.Deployment
{
    [_XType(typeof(Deployment_Engineer))]
    [_XString("Determine whether the rollout of a particular release into production has been successful or not.")]
    public class Verify_Successful_Deployment
    {
        [_XType(typeof(Developer))]
        [_XType(typeof(Product_Owner))]
        public Verify_Successful_Deployment()
        {

        }
    }
}
