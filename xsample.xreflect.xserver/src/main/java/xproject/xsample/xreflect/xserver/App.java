package xproject.xsample.xreflect.xserver;

import org.openqa.selenium.remote.RemoteWebDriver;

import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xlang.impl.XClassLoaderImpl;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xlang.xrmi.impl.XRemoteFactoryImpl;
import xproject.xrmi.xregistry.XRegistry;
import xproject.xrmi.xregistry.impl.XRegistryImpl;
import xproject.xrmi.xregistry.impl.XRemoteRegistryImpl;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xscript.impl.XBindingsImpl;
import xproject.xscript.impl.XScriptContextImpl;
import xproject.xscript.impl.XScriptEngineImpl;
import xproject.xscript.xrmi.impl.XRemoteBindingsImpl;
import xproject.xscript.xrmi.impl.XRemoteScriptContextImpl;
import xproject.xscript.xrmi.impl.XRemoteScriptEngineImpl;

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
	        XScriptContext xscriptContext = XScriptContextImpl.xnew(xengine, xglobal);
			xscriptContext = XRemoteScriptContextImpl.xnew(xscriptContext);
			
			XScriptEngine xscriptEngine = XScriptEngineImpl.xnew(xremote, xclass.xgetClassLoader());
			xscriptEngine = XRemoteScriptEngineImpl.xnew(xscriptEngine);
			
			XAgent xagent = null;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
