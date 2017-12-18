package xproject.xsample.xreflect.xclient;

import xproject.xlang.XClass;
import xproject.xlang.xreflect.XMethod;
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
        try
        {
	        XClass cls = (XClass) registry.xlookup("RemoteWebDriver");
			System.out.println(cls.xgetName());
			for(XMethod method : cls.xgetMethods())
			{
				System.out.println(method.xgetName());
			}
        }
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
    }
}
