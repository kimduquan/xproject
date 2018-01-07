package xproject.xsample.xreflect.xclient;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XParameter;
import xproject.xrmi.xregistry.XRegistry;
import xproject.xrmi.xregistry.impl.XRegistryImpl;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;

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
			XObject xthis = xbindings.xget("this");
			System.out.println(xthis.xtoString());
        }
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
    }
}
