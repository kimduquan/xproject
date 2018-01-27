package xproject.xlang.xrmi.impl;

import xproject.xlang.XClass;
import xproject.xlang.XClassLoader;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;

public class XRemoteClassLoaderImpl extends XUnicastRemoteObject<XClassLoader> implements XClassLoader {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected XRemoteClassLoaderImpl(XClassLoader ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public XClass xloadClass(String name) throws Exception {
		// TODO Auto-generated method stub
		return ref().xloadClass(name);
	}

	public static XRemoteClassLoaderImpl xnew(XClassLoader xclassLoader) throws Exception
	{
		return new XRemoteClassLoaderImpl(xclassLoader);
	}
}
