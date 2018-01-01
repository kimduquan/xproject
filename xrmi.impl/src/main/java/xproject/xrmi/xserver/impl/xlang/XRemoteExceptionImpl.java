package xproject.xrmi.xserver.impl.xlang;

import xproject.xlang.XException;
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

}
