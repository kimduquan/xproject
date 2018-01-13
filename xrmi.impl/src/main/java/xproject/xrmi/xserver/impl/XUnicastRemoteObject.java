package xproject.xrmi.xserver.impl;
import java.rmi.server.UnicastRemoteObject;

import xproject.xrmi.XRemote;

public class XUnicastRemoteObject<T> extends UnicastRemoteObject implements XRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private T remote;

	protected XUnicastRemoteObject(T ref) throws Exception {
		super();
		// TODO Auto-generated constructor stub
		remote = ref;
	}

	protected T ref()
	{
		return remote;
	}
	
	public static boolean xunexportObject(XRemote xremote, boolean force) throws Exception
	{
		return XUnicastRemoteObject.unexportObject(xremote, force);
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xunexportObject(this, true);
		finalize();
	}
}
