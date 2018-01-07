package xproject.xscript.xrmi.impl;

import xproject.xlang.XObject;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;
import xproject.xscript.XBindings;

public class XRemoteBindingsImpl extends XUnicastRemoteObject<XBindings> implements XBindings {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected XRemoteBindingsImpl(XBindings ref) throws Exception {
		super(ref);
	}

	public XObject xget(String key) throws Exception {
		// TODO Auto-generated method stub
		return ref().xget(key);
	}

	public XObject xput(String name, XObject object) throws Exception {
		// TODO Auto-generated method stub
		return ref().xput(name, object);
	}

	public boolean xcontainsKey(String key) throws Exception {
		// TODO Auto-generated method stub
		return ref().xcontainsKey(key);
	}

	public void xremove(String key) throws Exception {
		// TODO Auto-generated method stub
		ref().xremove(key);
	}

	public static XBindings xnew(XBindings ref) throws Exception
	{
		return new XRemoteBindingsImpl(ref);
	}
}
