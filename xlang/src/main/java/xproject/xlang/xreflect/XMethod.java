package xproject.xlang.xreflect;

import xproject.xlang.XClass;

public interface XMethod {

	String xgetName();
	XClass xgetDeclaringClass();
	XModifier xgetModifiers();
	XParameter[] xgetParameters();
	int xgetParameterCount();
	XClass[] xgetParameterTypes();
}
