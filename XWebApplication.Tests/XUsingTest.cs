using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Edge;

namespace XWebApplication.Tests
{
    [TestClass]
    public class XUsingTest
    {
        IWebDriver WebDriver { get; set; }

        [ClassInitialize]
        public void ClassInit()
        {
            WebDriver = new EdgeDriver("D:\\installed\\WebDrivers\\MicrosoftWebDriver.exe");
        }

        [ClassCleanup]
        public void ClassCleanUp()
        {
            WebDriver.Quit();
        }

        [TestMethod]
        public void xusing()
        {
            
        }
    }
}
