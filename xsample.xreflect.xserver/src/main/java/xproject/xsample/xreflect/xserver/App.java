package xproject.xsample.xreflect.xserver;

import org.openqa.selenium.remote.RemoteWebDriver;

import xproject.xlang.XClass;
import xproject.xlang.XFactory;
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
            XClass cls = xremote.xClass(RemoteWebDriver.class);
			registry.xbind(cls.xgetName(), cls);
			

	        xglobal = XRemoteBindingsImpl.xnew(xglobal);
	        xengine = XRemoteBindingsImpl.xnew(xengine);
	        XScriptContext xscriptContext = XScriptContextImpl.xnew(xengine, xglobal);
			xscriptContext = XRemoteScriptContextImpl.xnew(xscriptContext);
			registry.xbind("xproject.xscript.XScriptContext", xscriptContext);
			
			XScriptEngine xscriptEngine = XScriptEngineImpl.xnew(xremote, registry);
			xscriptEngine = XRemoteScriptEngineImpl.xnew(xscriptEngine);
			registry.xbind("xproject.xscript.XScriptEngine", xscriptEngine);
			
			registry.xbind("xproject.xrmi.xregistry.XRegistry", XRemoteRegistryImpl.xnew(registry));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
