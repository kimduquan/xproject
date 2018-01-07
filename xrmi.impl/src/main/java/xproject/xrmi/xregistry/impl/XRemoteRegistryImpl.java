package xproject.xrmi.xregistry.impl;

import xproject.xrmi.XRemote;
import xproject.xrmi.xregistry.XRegistry;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;

public class XRemoteRegistryImpl extends XUnicastRemoteObject<XRegistry> implements XRegistry {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected XRemoteRegistryImpl(XRegistry ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public void xbind(String name, XRemote remote) throws Exception {
		// TODO Auto-generated method stub
		ref().xbind(name, remote);
	}

	public void xrebind(String name, XRemote remote) throws Exception {
		// TODO Auto-generated method stub
		ref().xrebind(name, remote);
	}

	public String[] xlist() throws Exception {
		// TODO Auto-generated method stub
		return ref().xlist();
	}

	public XRemote xlookup(String name) throws Exception {
		// TODO Auto-generated method stub
		return ref().xlookup(name);
	}

	public void xunbind(String name) throws Exception {
		// TODO Auto-generated method stub
		ref().xunbind(name);
	}

	public static XRegistry xnew(XRegistry ref) throws Exception
	{
		return new XRemoteRegistryImpl(ref);
	}
}
