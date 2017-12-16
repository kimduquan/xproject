package xproject.xlang.xreflect;

import xproject.xlang.XClass;

public interface XConstructor {
	XClass xgetDeclaringClass();
	XModifier xgetModifiers();
	XParameter[] xgetParameters();
	int xgetParameterCount();
	XClass[] xgetParameterTypes();
}
