using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Tests
{
    [TestClass]
    public class XMethodInfoTest : XTest
    {
        public override void ClassInitialize()
        {
            
        }

        public XMethodInfo XMethodInfo { get; set; }

        public IEnumerable<object[]> Data { get; set; }

        //[DataTestMethod]
        //[DynamicData(nameof(Data), DynamicDataSourceType.Property)]
        public void XTestInvoke(object[] objects)
        {
            XParameterInfo[] xparameters = XMethodInfo.XGetParameters();
            for(int index = 0; index < xparameters.Length && index < objects.Length; index++)
            {
                XTestInvokeParameter(xparameters[index], objects[index]);
            }
            IWebElement submit = WebDriver.FindElement(By.Name(XMethodInfo.XName));
            Assert.IsNotNull(submit);
            submit.Click();
        }

        public void XTestInvoke_AccessKey(object[] objects)
        {
            XParameterInfo[] xparameters = XMethodInfo.XGetParameters();
            Dictionary<char, string> accessKeys = new Dictionary<char, string>();
            for (int index = 0; index < xparameters.Length && index < objects.Length; index++)
            {
                string name = xparameters[index].XName.ToLower();
                char accesskey = ' ';
                foreach(char ch in name)
                {
                    if(accessKeys.ContainsKey(ch) == false)
                    {
                        accesskey = ch;
                        accessKeys.Add(ch, name);
                        break;
                    }
                }
                XTestInvokeParameter_AccessKey(xparameters[index], objects[index], accesskey);
            }
            IWebElement submit = WebDriver.FindElement(By.Name(XMethodInfo.XName));
            Assert.IsNotNull(submit);
            submit.Click();
        }

        public void XTestInvoke_TabIndex(object[] objects)
        {
            XParameterInfo[] xparameters = XMethodInfo.XGetParameters();
            for (int index = 0; index < xparameters.Length && index < objects.Length; index++)
            {
                XTestInvokeParameter_TabIndex(xparameters[index], objects[index], index);
            }
            IWebElement submit = WebDriver.SwitchTo().ActiveElement();
            Assert.IsNotNull(submit);
            submit.SendKeys(Keys.Enter);
        }

        public void XAssertException()
        {
            IAlert alert = WebDriver.SwitchTo().Alert();
            Assert.IsNotNull(alert);
            string text = alert.Text;
            Assert.AreNotEqual("", text);
            alert.Accept();
        }

        protected void XTestInvokeParameter(XParameterInfo xparameter, object value)
        {
            By by = By.Name(xparameter.XName);
            IWebElement input = WebDriver.FindElement(by);
            Assert.IsNotNull(input);
            XType xtype = xparameter.XParameterType;
            if (xtype.XFullName == typeof(string).FullName)
            {
                input.SendKeys((string)value);
            }
        }

        protected void XTestInvokeParameter_AccessKey(XParameterInfo xparameter, object value, char accesskey)
        {
            IWebElement input = WebDriver.SwitchTo().ActiveElement();
            input.SendKeys(Keys.Alt + accesskey);
            input = WebDriver.SwitchTo().ActiveElement();
            Assert.IsNotNull(input);
            string accKey = input.GetAttribute("accesskey");
            Assert.AreEqual("" + accesskey, accKey);
            XType xtype = xparameter.XParameterType;
            if (xtype.XFullName == typeof(string).FullName)
            {
                input.SendKeys((string)value);
            }
        }

        protected void XTestInvokeParameter_TabIndex(XParameterInfo xparameter, object value, int index)
        {
            IWebElement input = WebDriver.SwitchTo().ActiveElement();
            input.SendKeys(Keys.Tab);
            input = WebDriver.SwitchTo().ActiveElement();
            Assert.IsNotNull(input);
            string tabIndex = input.GetAttribute("tabindex");
            Assert.AreEqual(index, int.Parse(tabIndex) - 1);
            XType xtype = xparameter.XParameterType;
            if (xtype.XFullName == typeof(string).FullName)
            {
                input.SendKeys((string)value);
            }
        }
    }
}
