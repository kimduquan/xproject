package xproject.xlang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XModifier;
import xproject.xlang.xreflect.XParameter;
import xproject.xrmi.XRemote;

public interface XFactory extends XRemote {

	XClass xClass(Class<?> cls) throws Exception;
	XObject xObject(Object obj) throws Exception;
	XPackage xPackage(Package pck) throws Exception;
	XConstructor xConstructor(Constructor<?> constructor) throws Exception;
	XField xField(Field field) throws Exception;
	XMethod xMethod(Method method) throws Exception;
	XModifier xModifier(int modifier) throws Exception;
	XParameter xParameter(Parameter param) throws Exception;
	XException xException(Exception ex) throws Exception;
	void xref(XFactory ref) throws Exception;
}
