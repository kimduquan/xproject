using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;

namespace XWebApplication.Tests
{
    [TestClass]
    public class XReturnTest : XTest
    {
        public void XTestReturn()
        {
            IWebElement link = WebDriver.FindElement(By.XPath("//a[@href='/return']"));
            Assert.IsNotNull(link);
            link.Click();
            link = WebDriver.FindElement(By.Name("return"));
            Assert.IsNotNull(link);
            link.Click();
        }
    }
}
