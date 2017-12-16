package xproject.xlang.xreflect;

import xproject.xlang.XClass;
import xproject.xlang.XObject;

public interface XField {

	XModifier xgetModifiers();
	XClass xgetType();
	XObject xget(XObject object) throws Exception;
	String xgetName();
	XClass xgetDeclaringClass();
}
