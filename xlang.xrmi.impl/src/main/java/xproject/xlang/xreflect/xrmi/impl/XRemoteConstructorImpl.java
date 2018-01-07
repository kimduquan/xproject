package xproject.xlang.xreflect.xrmi.impl;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XModifier;
import xproject.xlang.xreflect.XParameter;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;

public class XRemoteConstructorImpl extends XUnicastRemoteObject<XConstructor> implements XConstructor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XRemoteConstructorImpl(XConstructor ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
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

	public XObject xnewInstance(XObject[] xobjects) throws Exception {
		// TODO Auto-generated method stub
		return ref().xnewInstance(xobjects);
	}

}
