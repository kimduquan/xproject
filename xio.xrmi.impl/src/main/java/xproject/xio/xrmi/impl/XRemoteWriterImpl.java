package xproject.xio.xrmi.impl;

import xproject.xio.XWriter;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;

public class XRemoteWriterImpl extends XUnicastRemoteObject<XWriter> implements XWriter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected XRemoteWriterImpl(XWriter ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public void xwrite(String str) throws Exception {
		// TODO Auto-generated method stub
		ref().xwrite(str);
	}

	public void xflush() throws Exception {
		// TODO Auto-generated method stub
		ref().xflush();
	}

	public void xclose() throws Exception {
		// TODO Auto-generated method stub
		ref().xclose();
	}

	
}
