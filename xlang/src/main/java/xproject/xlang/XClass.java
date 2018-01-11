package xproject.xlang;

import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XModifier;
import xproject.xrmi.XRemote;

public interface XClass extends XRemote {

	XField[] xgetFields() throws Exception;
	boolean xisPrimitive() throws Exception;
	XMethod[] xgetMethods() throws Exception;
	String xgetSimpleName() throws Exception;
	String xgetName() throws Exception;
	boolean xisArray() throws Exception;
	XClass xgetComponentType() throws Exception;
	XClass xgetSuperClass() throws Exception;
	XConstructor[] xgetConstructors() throws Exception;
	XModifier xgetModifiers() throws Exception;
	static final String XOBJECT_CLASS_NAME = "java.lang.Object";
	XMethod xgetMethod(String name, XClass[] parameterTypes) throws Exception;
	XConstructor xgetConstructor(XClass[] parameterTypes) throws Exception;
	Class<?> x() throws Exception;
	
	boolean xisAssignableFrom(XClass xclass) throws Exception;
}
