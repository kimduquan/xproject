package xproject.xlang.xreflect.xrmi.impl;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XModifier;
import xproject.xlang.xreflect.XParameter;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;

public class XRemoteMethodImpl extends XUnicastRemoteObject<XMethod> implements XMethod {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XRemoteMethodImpl(XMethod ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public String xgetName() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetName();
	}

	public XClass xgetDeclaringClass() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetDeclaringClass();
	}

	public XModifier xgetModifiers() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetModifiers();
	}

	public XParameter[] xgetParameters() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetParameters();
	}

	public int xgetParameterCount() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetParameterCount();
	}

	public XClass[] xgetParameterTypes() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetParameterTypes();
	}

	public XObject xinvoke(XObject xobject, XObject[] xparameters)  throws Exception
	{
		// TODO Auto-generated method stub
		return ref().xinvoke(xobject, xparameters);
	}

	@Override
	public XClass xgetReturnType() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetReturnType();
	}

}
