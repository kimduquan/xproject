using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Edge;
using OpenUP.Roles.Basic_Roles;
using System.Collections.Generic;
using XSystem;
using XSystem.XInternal;
using XSystem.XReflection;
using XSystem.XReflection.XInternal;

namespace XWebApplication.Tests
{
    [TestClass]
    public class XUsingTest
    {
        IWebDriver WebDriver { get; set; }
        X X { get; set; }

        string Assembly { get; set; }
        /*XType XEntryType { get; set; }
        List<XMethodInfo> XMethods { get; set; }
        XMethodInfo XMethod { get; set; }
        List<XParameterInfo> XParameters { get; set; }
        XObject XUsingObject;
        XType XType { get; set; }*/

        [ClassInitialize]
        public void ClassInit()
        {
            WebDriver = new EdgeDriver("D:\\installed\\WebDrivers\\MicrosoftWebDriver.exe");
            X = new XInternal();
            X.XAssembly = XAssemblyInternal.XNew;
            Assembly = "OpenUP";
        }

        [ClassCleanup]
        public void ClassCleanUp()
        {
            WebDriver.Quit();
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

        }

        protected void xusingMultiEntryMethods(XType xentryType, List<XMethodInfo> xentryMethods)
        {

        }

        protected void xusingMethodNoParameter(XType xentryType, XMethodInfo xentryMethod)
        {

        }

        protected void xusingMethodParameters(XType xentryType, XMethodInfo xentryMethod, List<XParameterInfo> xparameters)
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
