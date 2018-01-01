package xproject.xsample.xreflect.xserver;

import org.openqa.selenium.remote.RemoteWebDriver;

import xproject.xlang.XClass;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xrmi.impl.XRemoteFactory;
import xproject.xrmi.impl.XRemoteFactoryImpl;
import xproject.xrmi.xregistry.XRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	XRemoteFactory factory = XRemoteFactoryImpl.xnew(XFactoryImpl.xnew());
    	
        XClass cls = factory.xClass(RemoteWebDriver.class);
        XRegistry registry = factory.xRegistry();
        
    	try {
			registry.xbind(cls.xgetName(), cls);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
