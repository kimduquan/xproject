package xproject.xsample.xreflect.xclient;

import xproject.xlang.XClass;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XParameter;
import xproject.xrmi.xregistry.XRegistry;
import xproject.xrmi.xregistry.impl.XRegistryImpl;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xutil.XScanner;
import xproject.xutil.impl.XScannerImpl;
import xproject.xutil.xrmi.impl.XRemoteScannerImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        XRegistry registry = XRegistryImpl.xnew();
        try
        {
	        XClass cls = (XClass) registry.xlookup("org.openqa.selenium.remote.RemoteWebDriver");
			System.out.println(cls.xgetName());
			for(XMethod method : cls.xgetMethods())
			{
				System.out.println(method.xgetName());
				for(XParameter param : method.xgetParameters())
				{
					System.out.println("\t" + param.xgetName() + " : " + param.xgetType().xgetName());
				}
			}
			
			XScriptContext xscriptContext = (XScriptContext) registry.xlookup("xproject.xscript.XScriptContext");
			XScriptEngine xscriptEngine = (XScriptEngine) registry.xlookup("xproject.xscript.XScriptEngine");
			XBindings xbindings = xscriptContext.xgetBindings(XScriptContext.XGLOBAL_SCOPE);
			
			XRegistry xremoteRegistry = (XRegistry) registry.xlookup("xproject.xrmi.xregistry.XRegistry");
			for(String name : xremoteRegistry.xlist())
			{
				System.out.println(name);
			}
			
			XScanner xscanner = XScannerImpl.xnew("InputStream", "System.in");
			xscanner = XRemoteScannerImpl.xnew(xscanner);
			registry.xbind("xproject.xutil.XScanner", xscanner);
			
			xscriptEngine.xeval(xscanner, xscriptContext);
        }
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
    }
}
