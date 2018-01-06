package xproject.xrmi.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import xproject.xlang.XClass;
import xproject.xlang.XException;
import xproject.xlang.XObject;
import xproject.xlang.XPackage;
import xproject.xlang.impl.XFactory;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xlang.xreflect.XArray;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XModifier;
import xproject.xlang.xreflect.XParameter;
import xproject.xrmi.xregistry.XRegistry;
import xproject.xrmi.xregistry.impl.XRegistryImpl;
import xproject.xrmi.xserver.impl.xlang.XRemoteClassImpl;
import xproject.xrmi.xserver.impl.xlang.XRemoteExceptionImpl;
import xproject.xrmi.xserver.impl.xlang.XRemoteObjectImpl;
import xproject.xrmi.xserver.impl.xlang.XRemotePackageImpl;
import xproject.xrmi.xserver.impl.xlang.xreflect.XRemoteArrayImpl;
import xproject.xrmi.xserver.impl.xlang.xreflect.XRemoteConstructorImpl;
import xproject.xrmi.xserver.impl.xlang.xreflect.XRemoteFieldImpl;
import xproject.xrmi.xserver.impl.xlang.xreflect.XRemoteMethodImpl;
import xproject.xrmi.xserver.impl.xlang.xreflect.XRemoteModifierImpl;
import xproject.xrmi.xserver.impl.xlang.xreflect.XRemoteParameterImpl;

public class XRemoteFactoryImpl extends XFactoryImpl {

	protected XRemoteFactoryImpl()
	{
	}
	
	public XClass xClass(Class<?> cls) throws Exception {
		// TODO Auto-generated method stub
		XClass xclass = super.xClass(cls);
		xclass = new XRemoteClassImpl(xclass);
		return xclass;
	}

	public XObject xObject(Object object) throws Exception {
		// TODO Auto-generated method stub
		XObject xobject = super.xObject(object);
		if(xobject instanceof XArray)
		{
			xobject = new XRemoteArrayImpl((XArray)xobject);
		}
		else
		{
			xobject = new XRemoteObjectImpl(xobject);
		}
		return xobject;
	}

	public XPackage xPackage(Package pkg) throws Exception {
		// TODO Auto-generated method stub
		XPackage xpkg = super.xPackage(pkg);
		xpkg = new XRemotePackageImpl(xpkg);
		return xpkg;
	}

	public XConstructor xConstructor(Constructor<?> constructor) throws Exception {
		// TODO Auto-generated method stub
		XConstructor xconstructor = super.xConstructor(constructor);
		xconstructor = new XRemoteConstructorImpl(xconstructor);
		return xconstructor;
	}

	public XField xField(Field field) throws Exception {
		// TODO Auto-generated method stub
		XField xfield = super.xField(field);
		xfield = new XRemoteFieldImpl(xfield);
		return xfield;
	}

	public XMethod xMethod(Method method) throws Exception {
		// TODO Auto-generated method stub
		XMethod xmethod = super.xMethod(method);
		xmethod = new XRemoteMethodImpl(xmethod);
		return xmethod;
	}

	public XModifier xModifier(int modifier) throws Exception {
		// TODO Auto-generated method stub
		XModifier xmodifier = super.xModifier(modifier);
		xmodifier = new XRemoteModifierImpl(xmodifier);
		return xmodifier;
	}

	public XParameter xParameter(Parameter param) throws Exception {
		// TODO Auto-generated method stub
		XParameter xparam = super.xParameter(param);
		xparam = new XRemoteParameterImpl(xparam);
		return xparam;
	}
	
	public static XFactory xnewRemoteFactory()
	{
		return new XRemoteFactoryImpl();
	}

	public XRegistry xRegistry() throws Exception {
		// TODO Auto-generated method stub
		return XRegistryImpl.xnew();
	}

	public XException xException(Exception ex) throws Exception {
		// TODO Auto-generated method stub
		XException xexception = super.xException(ex);
		xexception = new XRemoteExceptionImpl(xexception);
		return xexception;
	}
}
