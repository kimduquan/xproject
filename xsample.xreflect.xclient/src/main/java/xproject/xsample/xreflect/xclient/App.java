package xproject.xsample.xreflect.xclient;

import xproject.xagent.XAgent;
import xproject.xrmi.xregistry.XRegistry;
import xproject.xrmi.xregistry.impl.XRegistryImpl;
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
	        XAgent xagent = (XAgent) registry.xlookup("RemoteWebDriver");
			XScanner xscanner = XScannerImpl.xnew("InputStream", "System.in");
			xscanner = XRemoteScannerImpl.xnew(xscanner);
			
			XScriptEngine xengine = xagent.xgetScriptEngine();
			
			xengine.xeval(xscanner);
			
			xscanner.xclose();

			xscanner.xfinalize();
        }
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
