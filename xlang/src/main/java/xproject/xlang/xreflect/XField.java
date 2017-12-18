package xproject.xlang.xreflect;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XField extends XRemote {

	XModifier xgetModifiers() throws Exception;
	XClass xgetType() throws Exception;
	XObject xget(XObject object) throws Exception;
	String xgetName() throws Exception;
	XClass xgetDeclaringClass() throws Exception;
}
