package org.kdq.xlang;

import org.kdq.xlang.xreflect.XConstructor;
import org.kdq.xlang.xreflect.XField;
import org.kdq.xlang.xreflect.XMethod;

public interface XClass {

	String xgetName();
	String xgetSimpleName();
	XConstructor xgetConstructor(XClass... parameterTypes);
	XConstructor[] xgetConstructors();
	XField[] xgetFields();
	XField xgetField(String name);
	boolean xisInstance(XObject obj);
	XMethod xgetMethod(String name, XClass... parameterTypes);
	XMethod[] xgetMethods();
	XPackage xgetPackage();
	XClass xgetSupperclass();

}
