package xproject.xsample.xreflect.xserver;

import org.openqa.selenium.remote.RemoteWebDriver;

import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xlang.xrmi.impl.XRemoteFactoryImpl;
import xproject.xrmi.xregistry.XRegistry;
import xproject.xrmi.xregistry.impl.XRegistryImpl;

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
        
    	try 
    	{
    		xremote.xref(xfactory);
            XClass cls = xremote.xClass(RemoteWebDriver.class);
			registry.xbind(cls.xgetName(), cls);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
