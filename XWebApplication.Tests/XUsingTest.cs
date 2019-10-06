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

        private XType xentryType = null;
        private List<XMethodInfo> xentryMethods = null;
        private XMethodInfo xentryMethod = null;
        
        [ClassInitialize]
        public static void ClassInitialize(TestContext testContext)
        {
            if (WebDriver != null)
            {
                BaseURL = "https://localhost:44329";
            }
        }

        [ClassCleanup]
        public static void ClassCleanup()
        {
            WebDriver.Quit();
        }

        [TestCleanup]
        public void TestCleanup()
        {
            //WebDriver.Close();
        }

        [TestInitialize]
        public void TestInitialize()
        {
            Assembly = "OpenUP";
            EntryType = string.Format("{0}.{0}, {0}", Assembly);
            if (XEntryType != null)
            {
            }
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
                yield return new object[] { "OpenUP",  new object[] { "analyst", "analyst" } };
                yield return new object[] { "OpenUP/Tasks-Architecture/Envision_the_Architecture", new object[] { "architect", "architect" } };
                yield return new object[] { "OpenUP/Roles-Basic_Roles/Developer", new object[] { "developer", "developer" } };
                //yield return new object[] { "",  new object[] { "project manager", "project manager" } };
                //yield return new object[] {"",  new object[] { "stakeholder", "stakeholder" } };
                //yield return new object[] {"",  new object[] { "tester", "tester" } };
            }
        }

        [DataTestMethod]
        [DynamicData(nameof(Data), DynamicDataSourceType.Property)]
        public void XTestUsing(string xusing, object[] values)
        {
            string url = string.Format("{0}/{1}", BaseURL, xusing);
            WebDriver.Navigate().GoToUrl(url);
            string expectedUrl = string.Format("{0}/using?ReturnUrl=", BaseURL);
            Assert.IsTrue(WebDriver.Url.Contains(expectedUrl));
            if (XEntryType != null)
            {
                XMethodInfoTest xmethodTest = new XMethodInfoTest()
                {
                    XMethodInfo = XEntryMethod 
                };
                xmethodTest.XTestInvoke(values);
                Assert.IsTrue(WebDriver.Url.Contains(url));
            }
            else
            {
                XTestUsingNoEntryType();
            }
            XReturnTest xtest = new XReturnTest();
            xtest.XTestReturn();
        }

        [DataTestMethod]
        [DynamicData(nameof(Data), DynamicDataSourceType.Property)]
        public void XTestUsing_TabIndex(string xusing, object[] values)
        {
            string url = string.Format("{0}/{1}", BaseURL, xusing);
            WebDriver.Navigate().GoToUrl(url);
            string expectedUrl = string.Format("{0}/using?ReturnUrl=", BaseURL);
            Assert.IsTrue(WebDriver.Url.Contains(expectedUrl));
            if (XEntryType != null)
            {
                XMethodInfoTest xmethodTest = new XMethodInfoTest()
                {
                    XMethodInfo = XEntryMethod
                };
                xmethodTest.XTestInvoke_TabIndex(values);
                Assert.IsTrue(WebDriver.Url.Contains(url));
            }
            else
            {
                XTestUsingNoEntryType();
            }
            XReturnTest xtest = new XReturnTest();
            xtest.XTestReturn();
        }

        [DataTestMethod]
        [DynamicData(nameof(Data), DynamicDataSourceType.Property)]
        public void XTestUsing_AccessKey(string xusing, object[] values)
        {
            string url = string.Format("{0}/{1}", BaseURL, xusing);
            WebDriver.Navigate().GoToUrl(url);
            string expectedUrl = string.Format("{0}/using?ReturnUrl=", BaseURL);
            Assert.IsTrue(WebDriver.Url.Contains(expectedUrl));
            if (XEntryType != null)
            {
                XMethodInfoTest xmethodTest = new XMethodInfoTest()
                {
                    XMethodInfo = XEntryMethod
                };
                expectedUrl = url;
                xmethodTest.XTestInvoke_AccessKey(values);
                Assert.AreEqual(expectedUrl, WebDriver.Url);
            }
            else
            {
                XTestUsingNoEntryType();
            }
            XReturnTest xtest = new XReturnTest();
            xtest.XTestReturn();
        }

        [DataTestMethod]
        [DynamicData(nameof(Data), DynamicDataSourceType.Property)]
        public void XTestUsing_Try(string xusing, object[] values)
        {
            string url = string.Format("{0}/{1}", BaseURL, xusing);
            WebDriver.Navigate().GoToUrl(url);
            string expectedUrl = string.Format("{0}/using?ReturnUrl=", BaseURL);
            Assert.IsTrue(WebDriver.Url.Contains(expectedUrl));
            if (XEntryType != null)
            {
                expectedUrl = WebDriver.Url;
                object[] invalidValues = new object[] { "", "invalid" };
                XMethodInfoTest xtest = new XMethodInfoTest()
                {
                    XMethodInfo = XEntryMethod
                };
                xtest.XTestInvoke_ThrowException(invalidValues);
                Assert.AreEqual(expectedUrl, WebDriver.Url);

                invalidValues = new object[] { "invalid", "invalid" };
                xtest.XTestInvoke_AccessKey(invalidValues);
                Assert.AreEqual(expectedUrl, WebDriver.Url);

                expectedUrl = url;
                xtest.XTestInvoke_TabIndex(values);
                Assert.AreEqual(expectedUrl, WebDriver.Url);
            }
            else
            {
                XTestUsingNoEntryType();
            }
            XReturnTest xreturn = new XReturnTest();
            xreturn.XTestReturn();
        }

        protected void XTestUsingNoEntryType()
        {

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
                XMethodInfoTest xtest = new XMethodInfoTest()
                {
                    XMethodInfo = XEntryMethod
                };
                xtest.XTestInvoke_ThrowException(values);
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
                XMethodInfoTest xmethodTest = new XMethodInfoTest()
                {
                    XMethodInfo = XEntryMethod
                };
                xmethodTest.XTestInvoke_TabIndex(values);
                Assert.AreEqual(url, WebDriver.Url);
            }
            else
            {
                XTestUsingNoEntryType();
            }
        }

        [TestMethod]
        public void XTestUsing_InvalidUsing()
        {
            if (XEntryType != null)
            {
                string url = string.Format("{0}/{1}/{1}", BaseURL, XEntryType.XName);
                WebDriver.Navigate().GoToUrl(url);
                Assert.AreEqual(url, WebDriver.Url);
                url = string.Format("{0}/{1}", BaseURL, "invalid");
                WebDriver.Navigate().GoToUrl(url);
                string innerText = WebDriver.FindElement(By.TagName("body")).Text;
                Assert.IsTrue(innerText.Contains("HTTP ERROR 404"));
                url = string.Format("{0}/{1}/{1}", BaseURL, "invalid");
                WebDriver.Navigate().GoToUrl(url);
                Assert.IsTrue(innerText.Contains("HTTP ERROR 404"));
            }
            else
            {
                XTestUsingNoEntryType();
            }
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
