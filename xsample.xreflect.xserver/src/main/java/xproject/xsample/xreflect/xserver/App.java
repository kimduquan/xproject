package xproject.xsample.xreflect.xserver;

import org.openqa.selenium.remote.RemoteWebDriver;

import xproject.xlang.XClass;
import xproject.xlang.impl.XClassImpl;
import xproject.xrmi.xregistry.XRegistry;
import xproject.xrmi.xregistry.impl.XRegistryImpl;
import xproject.xrmi.xserver.XUnicastRemoteObject;
import xproject.xrmi.xserver.impl.XUnicastRemoteObjectImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        XClass cls = XClassImpl.xnew(RemoteWebDriver.class);
        try {
        	XUnicastRemoteObject remote = XUnicastRemoteObjectImpl.xnew();
        	cls = (XClass) remote.xexportObject(cls, 6789);
        	XRegistry registry = XRegistryImpl.xnew();
        	registry.xbind(cls.xgetSimpleName(), cls);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
