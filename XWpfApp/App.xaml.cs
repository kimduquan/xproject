using System.Collections.Generic;
using System.Windows;
using System.Windows.Threading;
using XSystem;
using XSystem.XComponentModel;
using XSystem.XComponentModel.XInternal;
using XSystem.XInternal;
using XSystem.XReflection;
using XSystem.XReflection.XInternal;

namespace XWpfApp
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        private void Application_Startup(object sender, StartupEventArgs e)
        {
            X = new XInternal();
            X.XAssembly = XAssemblyInternal.XNew;

            List<string> argNames = new List<string>();
            List<string> argValues = new List<string>();
            for (int i = 0; i < e.Args.Length; i++)
            {
                string arg = e.Args[i];
                if (arg.StartsWith("-"))
                {
                    int index = arg.IndexOf("=");
                    if (index > 0)
                    {
                        string name = arg.Substring(1, index - 1);
                        string value = arg.Substring(index + 1);
                        argNames.Add(name);
                        argValues.Add(value);
                    }
                }
            }

            string assembly = FindResource("Assembly").ToString();
            string type = string.Format("{0}.{0},{0}", assembly);
            XType = X.XGetType(type);
            XTypeConverter = new XObjectConverterInternal(X);
            XConstructorInfo xconstructor = null;
            List<XObject> xparams = null;
            foreach (XConstructorInfo xctor in XType.XGetConstructors())
            {
                bool match = true;
                List<XObject> xvalues = new List<XObject>();
                IEnumerator<string> name = argNames.GetEnumerator();
                IEnumerator<string> value = argValues.GetEnumerator();
                List<XParameterInfo> xparmeters = new List<XParameterInfo>(xctor.XGetParameters());
                IEnumerator<XParameterInfo> xparam = xparmeters.GetEnumerator();
                while(name.MoveNext() && value.MoveNext() && xparam.MoveNext())
                {
                    match = false;
                    if (name.Current == xparam.Current.XName)
                    {
                        XType xparamType = xparam.Current.XParameterType;
                        if(XTypeConverter.XCanConvertTo(xparamType))
                        {
                            XObject xvalue = XTypeConverter.XConvertTo(value, xparamType);
                            if(xvalue != null)
                            {
                                xvalues.Add(xvalue);
                                match = true;
                            }
                        }
                    }
                    if(match == false)
                    {
                        break;
                    }
                }
                if(match)
                {
                    xconstructor = xctor;
                    xparams = xvalues;
                    break;
                }
            }
            XObject = null;
            if (xconstructor != null)
            {
                XObject = xconstructor.XInvoke(xparams.ToArray());
            }
        }

        public XAssembly XAssembly { get; protected set; }
        public XType XType { get; protected set; }
        public X X { get; protected set; }
        public XTypeConverter XTypeConverter { get; protected set; }
        public XObject XObject { get; protected set; }

        private void Application_DispatcherUnhandledException(object sender, DispatcherUnhandledExceptionEventArgs e)
        {
            MessageBox.Show(e.Exception.Message, e.Exception.GetType().Name);
            e.Handled = true;
        }
    }
}
