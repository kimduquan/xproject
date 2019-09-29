using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenUP.Roles.Basic_Roles;
using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Tests
{
    [TestClass]
    public class XUsingTest : XTest
    {
        private string Assembly { get; set; }
        private string EntryType { get; set; }
        private string BaseURL { get; set; }

        private XType xentryType = null;
        private List<XMethodInfo> xentryMethods = null;
        private XMethodInfo xentryMethod = null;

        public override void ClassInitialize()
        {

        }

        [TestInitialize]
        public void TestInitialize()
        {
            Assembly = "OpenUP";
            BaseURL = "https://localhost:44329";
            EntryType = string.Format("{0}.{0}, {0}", Assembly);
            if (XEntryType != null)
            {
                string url = string.Format("{0}/{1}", BaseURL, XEntryType.XName);
                WebDriver.Navigate().GoToUrl(url);
            }
        }

        [TestCleanup]
        public void TestCleanup()
        {
            WebDriver.Close();
        }

        public XType XEntryType
        {
            get
            {
                if(xentryType == null)
                {
                    xentryType = X.XGetType(EntryType);
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

        public static IEnumerable<object[]> Data
        {
            get 
            {
                yield return new object[] { new object[] { "analyst", "analyst" } };
                yield return new object[] { new object[] { "architect", "architect" } };
                yield return new object[] { new object[] { "developer", "developer" } };
                yield return new object[] { new object[] { "project manager", "project manager" } };
                yield return new object[] { new object[] { "stakeholder", "stakeholder" } };
                yield return new object[] { new object[] { "tester", "tester" } };
            }
        }

        public static IEnumerable<object[]> InvalidData
        {
            get
            {
                yield return new object[] { new object[] { "", "invalid" } };
            }
        }

        [DataTestMethod]
        [DynamicData(nameof(Data), DynamicDataSourceType.Property)]
        public void XTestUsing(object[] values)
        {
            if(XEntryType != null)
            {
                string url = string.Format("{0}/{1}", BaseURL, XEntryType.XName);
                WebDriver.Navigate().GoToUrl(url);
                XTestUsingEntryType(values);
            }
            else
            {
                XTestUsingNoEntryType();
            }
            XReturnTest xtest = new XReturnTest()
            {
                WebDriver = WebDriver
            };
            xtest.XTestReturn();
        }

        [DataTestMethod]
        [DynamicData(nameof(InvalidData), DynamicDataSourceType.Property)]
        public void XTestUsingInvalid(object[] values)
        {
            if (XEntryType != null)
            {
                string url = string.Format("{0}/{1}", BaseURL, XEntryType.XName);
                WebDriver.Navigate().GoToUrl(url);
                XTestUsingEntryType(values);
            }
            else
            {
                XTestUsingNoEntryType();
            }
            XMethodInfoTest xtest = new XMethodInfoTest()
            {
                WebDriver = WebDriver
            };
            xtest.XTestException();
        }

        protected void XTestUsingNoEntryType()
        {

        }

        protected void XTestUsingEntryType(object[] values)
        {
            if(XEntryMethods.Count == 0)
            {
                XTestUsingNoEntryMethod();
            }
            else if(XEntryMethods.Count == 1)
            {
                XTestUsingEntryMethod(values);
            }
            else
            {
                XTestUsingEntryMethods();
            }
        }

        protected void XTestUsingNoEntryMethod()
        {
            XType xtype = X.XTypeOf(typeof(Developer));
            foreach(XType type in xtype.XAssembly.XExportedTypes)
            {
                XTestTypeNoObject(type);
            }
        }

        protected void XTestUsingEntryMethod(object[] values)
        {
            XMethodInfoTest xtest = new XMethodInfoTest
            {
                WebDriver = WebDriver,
                XMethodInfo = XEntryMethod
            };
            xtest.XTestInvoke(values);
            
        }

        protected void XTestUsingEntryMethods()
        {
            
        }

        protected void xusingNoObject(XType xentryType, XMethodInfo xentryMethod, List<XParameterInfo> xparameters)
        {

        }

        protected void xusingObject(XType xentryType, XMethodInfo xentryMethod, List<XParameterInfo> xparameters, XObject xobject)
        {

        }

        protected void XTestTypeNoObject(XType xtype)
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
