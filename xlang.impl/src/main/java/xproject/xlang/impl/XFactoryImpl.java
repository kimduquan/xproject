package xproject.xlang.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import xproject.xlang.XClass;
import xproject.xlang.XException;
import xproject.xlang.XFactory;
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

	private XFactory xref;
	
	protected XFactoryImpl()
	{
		xref = null;
	}
	
	protected XFactory xref()
	{
		if(xref == null)
			return this;
		return xref;
	}
	
	public XClass xClass(Class<?> cls) throws Exception {
		// TODO Auto-generated method stub
		return XClassImpl.xnew(cls, xref());
	}

	public XObject xObject(Object object) throws Exception {
		// TODO Auto-generated method stub
		if(object == null)
			return XObject.xnull;
		
		if(object.getClass().isArray())
			return XArrayImpl.xnew(object, xref());
		
		return XObjectImpl.xnew(object, xref());
	}

	public XPackage xPackage(Package pkg) throws Exception {
		// TODO Auto-generated method stub
		return XPackageImpl.xnew(pkg);
	}

	public XConstructor xConstructor(Constructor<?> constructor) throws Exception {
		// TODO Auto-generated method stub
		return XConstructorImpl.xnew(constructor, xref());
	}

	public XField xField(Field field) throws Exception {
		// TODO Auto-generated method stub
		return XFieldImpl.xnew(field, xref());
	}

	public XMethod xMethod(Method method) throws Exception {
		// TODO Auto-generated method stub
		return XMethodImpl.xnew(method, xref());
	}

	public XModifier xModifier(int modifier) throws Exception {
		// TODO Auto-generated method stub
		return XModifierImpl.xnew(modifier);
	}

	public XParameter xParameter(Parameter param) throws Exception {
		// TODO Auto-generated method stub
		return XParameterImpl.xnew(param, xref());
	}

	public static XFactory xnew()
	{
		return new XFactoryImpl();
	}

	public XException xException(Exception ex) throws Exception {
		// TODO Auto-generated method stub
		return XExceptionImpl.xnew(ex);
	}

	public void xref(XFactory ref) throws Exception {
		// TODO Auto-generated method stub
		xref = ref;
	}
}
