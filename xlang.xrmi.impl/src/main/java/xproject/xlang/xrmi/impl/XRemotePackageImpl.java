package xproject.xlang.xrmi.impl;

import xproject.xlang.XPackage;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;

public class XRemotePackageImpl extends XUnicastRemoteObject<XPackage> implements XPackage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XRemotePackageImpl(XPackage ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public String xgetName() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetName();
	}

}
