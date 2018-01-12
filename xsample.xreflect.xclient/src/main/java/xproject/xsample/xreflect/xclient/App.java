package xproject.xsample.xreflect.xclient;

import xproject.xrmi.xregistry.XRegistry;
import xproject.xrmi.xregistry.impl.XRegistryImpl;
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
	        //XClass cls = (XClass) registry.xlookup("org.openqa.selenium.remote.RemoteWebDriver");
			
			XScriptContext xscriptContext = (XScriptContext) registry.xlookup("xproject.xscript.XScriptContext");
			XScriptEngine xscriptEngine = (XScriptEngine) registry.xlookup("xproject.xscript.XScriptEngine");
			
			XScanner xscanner = XScannerImpl.xnew("InputStream", "System.in");
			xscanner = XRemoteScannerImpl.xnew(xscanner);
			
			xscriptEngine.xeval(xscanner, xscriptContext);
			
			XRemoteScannerImpl.xunexportObject(xscanner, true);
        }
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
    }
}
