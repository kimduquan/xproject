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
                if(x == null)
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

        private IWebDriver webDriver = null;

        public IWebDriver WebDriver
        {
            get
            {
                if(webDriver == null)
                {
                    webDriver = new ChromeDriver("D:\\installed\\WebDrivers");
                }
                return webDriver;
            }
            set
            {
                webDriver = value;
            }
        }

        [ClassInitialize]
        public abstract void ClassInitialize();

        [ClassCleanup]
        public void ClassCleanup()
        {
            WebDriver.Quit();
        }

        public XTest()
        {

        }
        public XTest(XTest test)
        {
            X = test.X;
            WebDriver = test.WebDriver;
        }
    }
}
