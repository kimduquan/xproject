using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenUP.Roles.Basic_Roles;
using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;
using XWebApplication.Models;
using XWebApplication.Models.XSystem;

namespace XWebApplication.Tests
{
    [TestClass]
    public class XUsingTest : XTest
    {
        private string Assembly { get; set; }
        private string BaseURL { get; set; }
        private XType xentryType = null;
        private List<XMethodInfo> xentryMethods = null;
        private XMethodInfo xentryMethod = null;

        public override void ClassInitialize()
        {
            Assembly = "OpenUP";
            BaseURL = "https://localhost:";
        }

        public XType XEntryType
        {
            get
            {
                if(xentryType == null)
                {
                    xentryType = X.XGetType(Assembly + ", " + Assembly);
                }
                return xentryType;
            }
        }

        public List<XMethodInfo> XEntryMethods
        {
            get
            {
                if(xentryMethods == null)
                {
                    xentryMethods = new List<XMethodInfo>();
                    foreach (XMethodInfo xmethod in XEntryType.XGetMethods())
                    {
                        if (xmethod.XIsStatic)
                        {
                            xentryMethods.Add(xmethod);
                        }
                    }
                }
                return xentryMethods;
            }
        }

        public XMethodInfo XEntryMethod
        {
            get
            {
                if(xentryMethod == null)
                {
                    if(XEntryMethods.Count == 1)
                    {
                        xentryMethod = XEntryMethods[0];
                    }
                }
                return xentryMethod;
            }
        }

        [TestMethod]
        public void XTestNavigateFromAssembly()
        {
            if(XEntryType != null)
            {
                string url = BaseURL + _XTypeModel.XToHref(XEntryType);
                WebDriver.Navigate().GoToUrl(url);
            }
        }

        public void xusing()
        {
            XType xentryType = X.XGetType(Assembly +", "+Assembly);
            if(xentryType != null)
            {
                xusingEntryType(xentryType);
            }
            else
            {
                xusingNoEntryType();
            }
        }

        protected void xusingNoEntryType()
        {

        }

        protected void xusingEntryType(XType xentryType)
        {
            List<XMethodInfo> xentryMethods = new List<XMethodInfo>();
            foreach(XMethodInfo xmethod in xentryType.XGetMethods())
            {
                if(xmethod.XIsStatic)
                {
                    xentryMethods.Add(xmethod);
                }
            }
            if(xentryMethods.Count == 0)
            {
                xusingNoEntryMethod(xentryType);
            }
            else if(xentryMethods.Count == 1)
            {
                xusingEntryMethod( xentryType, xentryMethods[0]);
            }
            else
            {
                xusingMultiEntryMethods( xentryType, xentryMethods);
            }
        }

        protected void xusingNoEntryMethod(XType xentryType)
        {
            XType xtype = X.XTypeOf(typeof(Developer));
            foreach(XType type in xtype.XAssembly.XExportedTypes)
            {
                xusingTypeNoObject(type);
            }
        }

        protected void xusingEntryMethod(XType xentryType, XMethodInfo xentryMethod)
        {
            XParameterInfo[] xparameters = xentryMethod.XGetParameters();
            if(xparameters == null || xparameters.Length == 0)
            {
                xusingMethodNoParameter(xentryType, xentryMethod);
            }
            else
            {
                xusingMethodParameters(xentryType, xentryMethod, xparameters);
            }
        }

        protected void xusingMultiEntryMethods(XType xentryType, List<XMethodInfo> xentryMethods)
        {
            foreach(XMethodInfo xmethod in xentryMethods)
            {
                xusingEntryMethod(xentryType, xmethod);
            }
        }

        protected void xusingMethodNoParameter(XType xentryType, XMethodInfo xentryMethod)
        {

        }

        protected void xusingMethodParameters(XType xentryType, XMethodInfo xentryMethod, XParameterInfo[] xparameters)
        {

        }

        protected void xusingNoObject(XType xentryType, XMethodInfo xentryMethod, List<XParameterInfo> xparameters)
        {

        }

        protected void xusingObject(XType xentryType, XMethodInfo xentryMethod, List<XParameterInfo> xparameters, XObject xobject)
        {

        }

        protected void xusingTypeNoObject(XType xtype)
        {

        }

        protected void xusingTypeWithObject(XType xtype, XObject xobject)
        {

        }

        protected void xreturn(XType xusingType, XObject xusingObject)
        {

        }
    }
}
