package xproject.xrmi.xserver.impl.xlang;

import xproject.xlang.XClass;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XModifier;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;

public class XRemoteClassImpl extends XUnicastRemoteObject<XClass> implements XClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XRemoteClassImpl(XClass xclass) throws Exception {
		super(xclass);
	}

	public XField[] xgetFields() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetFields();
	}

	public boolean xisPrimitive() throws Exception {
		// TODO Auto-generated method stub
		return ref().xisPrimitive();
	}

	public XMethod[] xgetMethods() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetMethods();
	}

	public String xgetSimpleName() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetSimpleName();
	}

	public String xgetName() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetName();
	}

	public boolean xisArray() throws Exception {
		// TODO Auto-generated method stub
		return ref().xisArray();
	}

	public XClass xgetComponentType() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetComponentType();
	}

	public XClass xgetSuperClass() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetSuperClass();
	}

	public XConstructor[] xgetConstructors() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetConstructors();
	}

	public XModifier xgetModifiers() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetModifiers();
	}

	public XMethod xgetMethod(String name, XClass[] parameterTypes) throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetMethod(name, parameterTypes);
	}

	public Class<?> x() {
		// TODO Auto-generated method stub
		return ref().x();
	}

	public XConstructor xgetConstructor(XClass[] parameterTypes) throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetConstructor(parameterTypes);
	}

}
