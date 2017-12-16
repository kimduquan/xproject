package xproject.xlang;

import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XModifier;

public interface XClass {

	XField[] xgetFields();
	boolean xisPrimitive();
	XMethod[] xgetMethods();
	String xgetSimpleName();
	String xgetName();
	boolean xisArray();
	XClass xgetComponentType();
	XClass xgetSuperClass();
	XConstructor[] xgetConstructors();
	XModifier xgetModifiers();
	static final String XOBJECT_CLASS_NAME = "java.lang.Object";
}
