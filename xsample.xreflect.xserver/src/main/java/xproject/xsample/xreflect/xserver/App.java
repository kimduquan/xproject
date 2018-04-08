package xproject.xsample.xreflect.xserver;

import org.openqa.selenium.remote.RemoteWebDriver;

import xproject.xagent.XAgent;
import xproject.xagent.impl.XAgentImpl;
import xproject.xagent.xrmi.impl.XRemoteAgentImpl;
import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xlang.xrmi.impl.XRemoteFactoryImpl;
import xproject.xrmi.xregistry.XRegistry;
import xproject.xrmi.xregistry.impl.XRegistryImpl;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xscript.impl.XBindingsImpl;
import xproject.xscript.impl.XScriptContextImpl;
import xproject.xscript.impl.XScriptEngineImpl;
import xproject.xscript.xrmi.impl.XRemoteBindingsImpl;
import xproject.xscript.xrmi.impl.XRemoteScriptContextImpl;
import xproject.xscript.xrmi.impl.XRemoteScriptEngineImpl;
import xproject.xutil.XScanner;
import xproject.xutil.impl.XScannerImpl;
import xproject.xutil.xconcurrent.XExecutorService;
import xproject.xutil.xconcurrent.XExecutors;
import xproject.xutil.xconcurrent.impl.XExecutorsImpl;
import xproject.xutil.xrmi.impl.XRemoteScannerImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	XFactory xfactory = XFactoryImpl.xnew();
    	XFactory xremote = XRemoteFactoryImpl.xnew();
        XRegistry registry = XRegistryImpl.xnew();
        
        XBindings xglobal = XBindingsImpl.xnew();
        XBindings xengine = XBindingsImpl.xnew();
        
    	try 
    	{
    		xremote.xref(xfactory);
    		XClass xclass = xremote.xClass(RemoteWebDriver.class);

	        xglobal = XRemoteBindingsImpl.xnew(xglobal);
	        xengine = XRemoteBindingsImpl.xnew(xengine);
	        XScriptContext xscriptContext = XScriptContextImpl.xnew(xengine, xglobal, null, null);
			xscriptContext = XRemoteScriptContextImpl.xnew(xscriptContext);
			
			XExecutors executors = XExecutorsImpl.xnew();
			XExecutorService executor = executors.xnewCachedThreadPool();
			//XScriptEngine xscriptEngine = XScriptEngineImpl.xnew(xremote, xclass.xgetClassLoader(), xscriptContext, executor, null);
			XScriptEngine xscriptEngine = XScriptEngineImpl.xnew(null);
			xscriptEngine = XRemoteScriptEngineImpl.xnew(xscriptEngine);
			
			XScanner xscanner = XScannerImpl.xnew("InputStream", "System.in");
			xscanner = XRemoteScannerImpl.xnew(xscanner);
			
			XAgent xagent = XAgentImpl.xnew("RemoteWebDriver", xscriptEngine, xscriptContext, xscanner);
			xagent = XRemoteAgentImpl.xnew(xagent);
			
			registry.xbind(xagent.xgetName(), xagent);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
