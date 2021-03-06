package xproject.xlang.xreflect;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XConstructor extends XRemote {
	XClass xgetDeclaringClass() throws Exception;
	XModifier xgetModifiers() throws Exception;
	XParameter[] xgetParameters() throws Exception;
	int xgetParameterCount() throws Exception;
	XClass[] xgetParameterTypes() throws Exception;
	XObject xnewInstance(XObject[] xobjects) throws Exception;
}
