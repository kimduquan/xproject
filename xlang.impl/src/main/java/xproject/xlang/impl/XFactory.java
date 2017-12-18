package xproject.xlang.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.XPackage;
import xproject.xlang.xreflect.XArray;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XModifier;
import xproject.xlang.xreflect.XParameter;

public interface XFactory {

	XClass xClass(Class<?> cls);
	XObject xObject(Object obj);
	XPackage xPackage(Package pck);
	XArray xArray(Object obj);
	XConstructor xConstructor(Constructor<?> constructor);
	XField xField(Field field);
	XMethod xMethod(Method method);
	XModifier xModifier(int modifier);
	XParameter xParameter(Parameter param);
}
