package xproject.xsample.xreflect.xserver;

import org.openqa.selenium.remote.RemoteWebDriver;

import xproject.xlang.XClass;
import xproject.xlang.impl.XFactory;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xrmi.impl.XRemoteFactoryImpl;
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
    	XFactoryImpl.xnew();
    	XFactory factory = XRemoteFactoryImpl.xnewRemoteFactory();
        XRegistry registry = XRegistryImpl.xnew();
        
    	try 
    	{
            XClass cls = factory.xClass(RemoteWebDriver.class);
			registry.xbind(cls.xgetName(), cls);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
