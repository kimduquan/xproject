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
import xproject.xlang.xreflect.impl.XArrayImpl;
import xproject.xlang.xreflect.impl.XConstructorImpl;
import xproject.xlang.xreflect.impl.XFieldImpl;
import xproject.xlang.xreflect.impl.XMethodImpl;
import xproject.xlang.xreflect.impl.XModifierImpl;
import xproject.xlang.xreflect.impl.XParameterImpl;

public class XFactoryImpl implements XFactory {

	protected XFactoryImpl()
	{
		
	}
	
	public XClass xClass(Class<?> cls) {
		// TODO Auto-generated method stub
		return XClassImpl.xnew(cls);
	}

	public XObject xObject(Object object) {
		// TODO Auto-generated method stub
		if(object == null)
			return XObject.NULL;
		
		if(object.getClass().isArray())
			return xArray(object);
		
		return XObjectImpl.xnew(object);
	}

	public XPackage xPackage(Package pkg) {
		// TODO Auto-generated method stub
		return XPackageImpl.xnew(pkg);
	}

	public XArray xArray(Object object) {
		// TODO Auto-generated method stub
		return XArrayImpl.xnew(object);
	}

	public XConstructor xConstructor(Constructor<?> constructor) {
		// TODO Auto-generated method stub
		return XConstructorImpl.xnew(constructor);
	}

	public XField xField(Field field) {
		// TODO Auto-generated method stub
		return XFieldImpl.xnew(field);
	}

	public XMethod xMethod(Method method) {
		// TODO Auto-generated method stub
		return XMethodImpl.xnew(method);
	}

	public XModifier xModifier(int modifier) {
		// TODO Auto-generated method stub
		return XModifierImpl.xnew(modifier);
	}

	public XParameter xParameter(Parameter param) {
		// TODO Auto-generated method stub
		return XParameterImpl.xnew(param);
	}

	private static XFactory defInstance = new XFactoryImpl();
	private static XFactory customInstance = null;
	
	public static XFactory get()
	{
		if(customInstance != null)
			return customInstance;
		return defInstance;
	}
	
	public static void set(XFactory factory)
	{
		customInstance = factory;
	}
}
