package xproject.xlang.xrmi.impl;

import xproject.xlang.XClass;
import xproject.xlang.XException;
import xproject.xlang.XObject;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;

public class XRemoteExceptionImpl extends XUnicastRemoteObject<XException> implements XException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XRemoteExceptionImpl(XException ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public String xgetMessage() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetMessage();
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

	public Object x() throws Exception {
		// TODO Auto-generated method stub
		return ref().x();
	}

	public void xthrow() throws Exception {
		// TODO Auto-generated method stub
		ref().xthrow();
	}

	public boolean xequals(XObject xobject) throws Exception {
		// TODO Auto-generated method stub
		return ref().xequals(xobject);
	}

}
