using System.Collections.Generic;
using System.Windows;
using System.Windows.Threading;
using XSystem;
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

            Dictionary<string, string> args = new Dictionary<string, string>();
            for (int i = 0; i < e.Args.Length; i++)
            {
                string arg = e.Args[i];
                if (arg.StartsWith("-"))
                {
                    int index = arg.IndexOf("=");
                    if (index > 0)
                    {
                        string name = arg.Substring(1, index);
                        string value = arg.Substring(index + 1);
                        args.Add(name, value);
                    }
                }
            }

            string assembly = FindResource("Assembly").ToString();
            string type = string.Format("{0}.{0},{0}", assembly);
            XType = X.XGetType(type);
            foreach(XConstructorInfo xconstructor in XType.XGetConstructors())
            {
            }
        }

        public XAssembly XAssembly { get; protected set; }
        public XType XType { get; protected set; }
        public X X { get; protected set; }

        private void Application_DispatcherUnhandledException(object sender, DispatcherUnhandledExceptionEventArgs e)
        {
            MessageBox.Show(e.Exception.Message, e.Exception.GetType().Name);
            e.Handled = true;
        }
    }
}
