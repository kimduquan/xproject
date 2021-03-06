package xproject.xlang.xreflect;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XMethod extends XRemote {

	String xgetName() throws Exception;
	XClass xgetDeclaringClass() throws Exception;
	XModifier xgetModifiers() throws Exception;
	XParameter[] xgetParameters() throws Exception;
	int xgetParameterCount() throws Exception;
	XClass[] xgetParameterTypes() throws Exception;
	XClass xgetReturnType() throws Exception;
	XObject xinvoke(XObject xobject, XObject[] xparameters) throws Exception;
}
