package xproject.xlang.impl;

import xproject.xlang.XClass;
import xproject.xlang.XClassLoader;
import xproject.xlang.XFactory;

public class XClassLoaderImpl implements XClassLoader {

	private ClassLoader clsLoader;
	private XFactory xfactory;
	
	protected XClassLoaderImpl(ClassLoader loader, XFactory factory)
	{
		clsLoader = loader;
		xfactory = factory;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		clsLoader = null;
		xfactory = null;
		finalize();
	}

	public XClass xloadClass(String name) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xClass(clsLoader.loadClass(name));
	}

	public static XClassLoader xnew(ClassLoader loader, XFactory factory)
	{
		return new XClassLoaderImpl(loader, factory);
	}
}
