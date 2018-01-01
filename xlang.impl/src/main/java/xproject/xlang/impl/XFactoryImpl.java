package xproject.xlang.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import xproject.xlang.XClass;
import xproject.xlang.XException;
import xproject.xlang.XObject;
import xproject.xlang.XPackage;
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
		return XClassImpl.xnew(cls, this);
	}

	public XObject xObject(Object object) {
		// TODO Auto-generated method stub
		if(object == null)
			return XObject.xnull;
		
		if(object.getClass().isArray())
			return XArrayImpl.xnew(object, this);
		
		return XObjectImpl.xnew(object, this);
	}

	public XPackage xPackage(Package pkg) {
		// TODO Auto-generated method stub
		return XPackageImpl.xnew(pkg);
	}

	public XConstructor xConstructor(Constructor<?> constructor) {
		// TODO Auto-generated method stub
		return XConstructorImpl.xnew(constructor, this);
	}

	public XField xField(Field field) {
		// TODO Auto-generated method stub
		return XFieldImpl.xnew(field, this);
	}

	public XMethod xMethod(Method method) {
		// TODO Auto-generated method stub
		return XMethodImpl.xnew(method, this);
	}

	public XModifier xModifier(int modifier) {
		// TODO Auto-generated method stub
		return XModifierImpl.xnew(modifier);
	}

	public XParameter xParameter(Parameter param) {
		// TODO Auto-generated method stub
		return XParameterImpl.xnew(param, this);
	}

	public static XFactory xnew()
	{
		return new XFactoryImpl();
	}

	public XException xException(Exception ex) {
		// TODO Auto-generated method stub
		return XExceptionImpl.xnew(ex);
	}
}
