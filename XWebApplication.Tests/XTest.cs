using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using XSystem;
using XSystem.XInternal;
using XSystem.XReflection.XInternal;

namespace XWebApplication.Tests
{
    public abstract class XTest
    {
        private X x = null;

        public X X
        {
            get
            {
                if (x == null)
                {
                    x = new XInternal();
                    x.XAssembly = XAssemblyInternal.XNew;
                }
                return x;
            }
            set
            {
                x = value;
            }
        }

        private static IWebDriver webDriver = null;

        public static IWebDriver WebDriver
        {
            get
            {
                if (webDriver == null)
                {
                    webDriver = new ChromeDriver("D:\\installed\\WebDrivers");
                }
                return webDriver;
            }
        }

        protected static string BaseURL { get; set; }

        public XTest()
        {

        }
        public XTest(XTest test)
        {
            X = test.X;
        }

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
            WebDriver.Close();
        }
    }
}
