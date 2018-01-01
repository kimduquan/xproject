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

public class XRemoteFactoryImpl implements XRemoteFactory {

	private XFactory ref;
	
	protected XRemoteFactoryImpl(XFactory r)
	{
		ref = r;
	}
	
	public XClass xClass(Class<?> cls) {
		// TODO Auto-generated method stub
		XClass xclass = ref.xClass(cls);
		try {
			xclass = new XRemoteClassImpl(xclass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xclass;
	}

	public XObject xObject(Object object) {
		// TODO Auto-generated method stub
		XObject xobject = ref.xObject(object);
		try 
		{
			if(xobject instanceof XArray)
			{
				xobject = new XRemoteArrayImpl((XArray)xobject);
			}
			else
			{
				xobject = new XRemoteObjectImpl(xobject);
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xobject;
	}

	public XPackage xPackage(Package pkg) {
		// TODO Auto-generated method stub
		XPackage xpkg = ref.xPackage(pkg);
		try {
			xpkg = new XRemotePackageImpl(xpkg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xpkg;
	}

	public XConstructor xConstructor(Constructor<?> constructor) {
		// TODO Auto-generated method stub
		XConstructor xconstructor = ref.xConstructor(constructor);
		try {
			xconstructor = new XRemoteConstructorImpl(xconstructor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xconstructor;
	}

	public XField xField(Field field) {
		// TODO Auto-generated method stub
		XField xfield = ref.xField(field);
		try {
			xfield = new XRemoteFieldImpl(xfield);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xfield;
	}

	public XMethod xMethod(Method method) {
		// TODO Auto-generated method stub
		XMethod xmethod = ref.xMethod(method);
		try {
			xmethod = new XRemoteMethodImpl(xmethod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xmethod;
	}

	public XModifier xModifier(int modifier) {
		// TODO Auto-generated method stub
		XModifier xmodifier = ref.xModifier(modifier);
		try {
			xmodifier = new XRemoteModifierImpl(xmodifier);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xmodifier;
	}

	public XParameter xParameter(Parameter param) {
		// TODO Auto-generated method stub
		XParameter xparam = ref.xParameter(param);
		try {
			xparam = new XRemoteParameterImpl(xparam);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xparam;
	}
	
	public static XRemoteFactory xnew(XFactory ref)
	{
		return new XRemoteFactoryImpl(ref);
	}

	public XRegistry xRegistry() {
		// TODO Auto-generated method stub
		return XRegistryImpl.xnew();
	}

	public XException xException(Exception ex) {
		// TODO Auto-generated method stub
		XException xexception = ref.xException(ex);
		try {
			xexception = new XRemoteExceptionImpl(xexception);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xexception;
	}
}
