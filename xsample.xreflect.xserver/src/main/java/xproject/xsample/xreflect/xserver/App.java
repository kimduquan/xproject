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
    	XFactory factory = XFactoryImpl.xnew();
    	XFactory xfactory = XRemoteFactoryImpl.xnew();
        XRegistry registry = XRegistryImpl.xnew();
        
    	try 
    	{
        	xfactory.xref(factory);
            XClass cls = xfactory.xClass(RemoteWebDriver.class);
			registry.xbind(cls.xgetName(), cls);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
