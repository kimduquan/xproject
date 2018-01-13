package xproject.xlang.xrmi.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import xproject.xlang.XClass;
import xproject.xlang.XException;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xlang.XPackage;
import xproject.xlang.xreflect.XArray;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XModifier;
import xproject.xlang.xreflect.XParameter;
import xproject.xlang.xreflect.xrmi.impl.XRemoteArrayImpl;
import xproject.xlang.xreflect.xrmi.impl.XRemoteConstructorImpl;
import xproject.xlang.xreflect.xrmi.impl.XRemoteFieldImpl;
import xproject.xlang.xreflect.xrmi.impl.XRemoteMethodImpl;
import xproject.xlang.xreflect.xrmi.impl.XRemoteModifierImpl;
import xproject.xlang.xreflect.xrmi.impl.XRemoteParameterImpl;
import xproject.xlang.xrmi.impl.XRemoteClassImpl;
import xproject.xlang.xrmi.impl.XRemoteExceptionImpl;
import xproject.xlang.xrmi.impl.XRemoteObjectImpl;
import xproject.xlang.xrmi.impl.XRemotePackageImpl;
import xproject.xrmi.XRemote;

public class XRemoteFactoryImpl implements XFactory {

	private XFactory xref;
	
	protected XRemoteFactoryImpl()
	{
		xref = null;
	}
	
	public XClass xClass(Class<?> cls) throws Exception {
		// TODO Auto-generated method stub
		XClass xclass = xref.xClass(cls);
		xclass = new XRemoteClassImpl(xclass);
		return xclass;
	}

	public XObject xObject(Object object) throws Exception {
		// TODO Auto-generated method stub
		XObject xobject = xref.xObject(object);
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
		XPackage xpkg = xref.xPackage(pkg);
		xpkg = new XRemotePackageImpl(xpkg);
		return xpkg;
	}

	public XConstructor xConstructor(Constructor<?> constructor) throws Exception {
		// TODO Auto-generated method stub
		XConstructor xconstructor = xref.xConstructor(constructor);
		xconstructor = new XRemoteConstructorImpl(xconstructor);
		return xconstructor;
	}

	public XField xField(Field field) throws Exception {
		// TODO Auto-generated method stub
		XField xfield = xref.xField(field);
		xfield = new XRemoteFieldImpl(xfield);
		return xfield;
	}

	public XMethod xMethod(Method method) throws Exception {
		// TODO Auto-generated method stub
		XMethod xmethod = xref.xMethod(method);
		xmethod = new XRemoteMethodImpl(xmethod);
		return xmethod;
	}

	public XModifier xModifier(int modifier) throws Exception {
		// TODO Auto-generated method stub
		XModifier xmodifier = xref.xModifier(modifier);
		xmodifier = new XRemoteModifierImpl(xmodifier);
		return xmodifier;
	}

	public XParameter xParameter(Parameter param) throws Exception {
		// TODO Auto-generated method stub
		XParameter xparam = xref.xParameter(param);
		xparam = new XRemoteParameterImpl(xparam);
		return xparam;
	}
	
	public static XFactory xnew()
	{
		return new XRemoteFactoryImpl();
	}

	public XException xException(Exception ex) throws Exception {
		// TODO Auto-generated method stub
		XException xexception = xref.xException(ex);
		xexception = new XRemoteExceptionImpl(xexception);
		return xexception;
	}

	public void xref(XFactory ref) throws Exception {
		// TODO Auto-generated method stub
		ref.xref(this);
		xref = ref;
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xref = null;
		finalize();
	}

	public void xfinalize(XRemote xremote) throws Exception {
		// TODO Auto-generated method stub
		try {
			xremote.xfinalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
