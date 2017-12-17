package xproject.xsample.xreflect.xclient;

import java.rmi.RemoteException;

import xproject.xlang.XClass;
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
        XRegistry registry = XRegistryImpl.xnew();
        try {
			XClass cls = (XClass) registry.lookup("RemoteWebDriver");
			System.out.println(cls.xgetName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
