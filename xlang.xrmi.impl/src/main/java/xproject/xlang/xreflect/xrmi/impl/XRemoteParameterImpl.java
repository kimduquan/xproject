package xproject.xlang.xreflect.xrmi.impl;

import xproject.xlang.XClass;
import xproject.xlang.xreflect.XParameter;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;

public class XRemoteParameterImpl extends XUnicastRemoteObject<XParameter> implements XParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XRemoteParameterImpl(XParameter ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public String xgetName() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetName();
	}

	public XClass xgetType() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetType();
	}

}
