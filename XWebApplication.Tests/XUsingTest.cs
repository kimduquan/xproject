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
                //yield return new object[] { new object[] { "project manager", "project manager" } };
                //yield return new object[] { new object[] { "stakeholder", "stakeholder" } };
                //yield return new object[] { new object[] { "tester", "tester" } };
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
                XTestUsingEntryType(values, "");
                Assert.IsTrue(WebDriver.Url.Contains(url));
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
        [DynamicData(nameof(Data), DynamicDataSourceType.Property)]
        public void XTestUsing_TabIndex(object[] values)
        {
            if (XEntryType != null)
            {
                string url = string.Format("{0}/{1}", BaseURL, XEntryType.XName);
                WebDriver.Navigate().GoToUrl(url);
                XTestUsingEntryType(values, "tabindex");
                Assert.IsTrue(WebDriver.Url.Contains(url));
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
        [DynamicData(nameof(Data), DynamicDataSourceType.Property)]
        public void XTestUsing_AccessKey(object[] values)
        {
            if (XEntryType != null)
            {
                string url = string.Format("{0}/{1}", BaseURL, XEntryType.XName);
                WebDriver.Navigate().GoToUrl(url);
                XTestUsingEntryType(values, "accesskey");
                Assert.IsTrue(WebDriver.Url.Contains(url));
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

        [TestMethod]
        public void XTestUsing_ThrowException()
        {
            if (XEntryType != null)
            {
                string url = string.Format("{0}/{1}", BaseURL, XEntryType.XName);
                WebDriver.Navigate().GoToUrl(url);
                url = WebDriver.Url;
                object[] values = new object[] { "", "invalid" };
                XTestUsingEntryType(values, "tabindex");
                XMethodInfoTest xtest = new XMethodInfoTest()
                {
                    WebDriver = WebDriver
                };
                xtest.XAssertException();
                Assert.AreEqual(url, WebDriver.Url);
            }
            else
            {
                XTestUsingNoEntryType();
            }
        }

        [TestMethod]
        public void XTestUsing_ReturnNull()
        {
            if (XEntryType != null)
            {
                string url = string.Format("{0}/{1}", BaseURL, XEntryType.XName);
                WebDriver.Navigate().GoToUrl(url);
                url = WebDriver.Url;
                object[] values = new object[] { "invalid", "invalid" };
                XTestUsingEntryType(values, "tabindex");
                Assert.AreEqual(url, WebDriver.Url);
            }
            else
            {
                XTestUsingNoEntryType();
            }
        }

        [DataTestMethod]
        [DynamicData(nameof(Data), DynamicDataSourceType.Property)]
        public void XTestUsing_Try(object[] values)
        {
            if (XEntryType != null)
            {
                string url = string.Format("{0}/{1}", BaseURL, XEntryType.XName);
                WebDriver.Navigate().GoToUrl(url);
                url = WebDriver.Url;
                object[] invalidValues = new object[] { "", "invalid" };
                XTestUsingEntryType(invalidValues, "tabindex");
                XMethodInfoTest xtest = new XMethodInfoTest()
                {
                    WebDriver = WebDriver
                };
                xtest.XAssertException();
                Assert.AreEqual(url, WebDriver.Url);

                invalidValues = new object[] { "invalid", "invalid" };
                XTestUsingEntryType(invalidValues, "tabindex");
                Assert.AreEqual(url, WebDriver.Url);

                XTestUsingEntryType(values, "tabindex");
            }
            else
            {
                XTestUsingNoEntryType();
            }
            XReturnTest xreturn = new XReturnTest()
            {
                WebDriver = WebDriver
            };
            xreturn.XTestReturn();
        }

        protected void XTestUsingNoEntryType()
        {

        }

        protected void XTestUsingEntryType(object[] values, string interact)
        {
            if(XEntryMethods.Count == 0)
            {
                XTestUsingNoEntryMethod();
            }
            else if(XEntryMethods.Count == 1)
            {
                XTestUsingEntryMethod(values, interact);
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

        protected void XTestUsingEntryMethod(object[] values, string interact)
        {
            XMethodInfoTest xtest = new XMethodInfoTest
            {
                WebDriver = WebDriver,
                XMethodInfo = XEntryMethod
            };
            if(interact == "")
            {
                xtest.XTestInvoke(values);
            }
            else if(interact == "tabindex")
            {
                xtest.XTestInvoke_TabIndex(values);
            }
            else if (interact == "accesskey")
            {
                xtest.XTestInvoke_AccessKey(values);
            }
        }

        protected void XTestUsingEntryMethods()
        {
            
        }

        protected void XTestTypeNoObject(XType xtype)
        {

        }
    }
}
