package xproject.xlang.xrmi.impl;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;

public class XRemoteObjectImpl extends XUnicastRemoteObject<XObject> implements XObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XRemoteObjectImpl(XObject ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public XClass xgetClass() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetClass();
	}

	public String xtoString() throws Exception {
		// TODO Auto-generated method stub
		return ref().xtoString();
	}

	public int xhashCode() throws Exception {
		// TODO Auto-generated method stub
		return ref().xhashCode();
	}

	public Object x() throws Exception
	{
		// TODO Auto-generated method stub
		return ref().x();
	}

	public void xfinalize() throws Exception {
		// TODO Auto-generated method stub
		ref().xfinalize();
	}

	
}
