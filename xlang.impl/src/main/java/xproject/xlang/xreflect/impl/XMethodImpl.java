package xproject.xlang.xreflect.impl;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import xproject.xlang.XClass;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XModifier;
import xproject.xlang.xreflect.XParameter;

public class XMethodImpl implements XMethod {

	private static HashMap<String, ArrayList<XMethod>> xmethods = new HashMap<String, ArrayList<XMethod>>();
	
	private Method method;
	private XModifier modifiers;
	private XParameter[] xparameters;
	private XClass[] xparameterTypes;
	private XClass declaringClass;
	
	protected XMethodImpl(Method m)
	{
		method = m;
		modifiers = null;
		xparameters = null;
		xparameterTypes = null;
		declaringClass = null;
	}
	
	protected void initializeParameters()
	{
		Parameter[] params = method.getParameters();
		xparameters = new XParameter[params.length];
		for(int i = 0; i < params.length; i++)
		{
			xparameters[i] = XFactoryImpl.get().xParameter(params[i]);
		}
	}
	
	protected void initializeParameterTypes()
	{
		Class<?>[] types = method.getParameterTypes();
		xparameterTypes = new XClass[types.length];
		for(int i = 0; i < types.length; i++)
		{
			xparameterTypes[i] = XFactoryImpl.get().xClass(types[i]);
		}
	}

	public String xgetName() {
		// TODO Auto-generated method stub
		return method.getName();
	}

	public XClass xgetDeclaringClass() {
		// TODO Auto-generated method stub
		if(declaringClass == null)
			declaringClass = XFactoryImpl.get().xClass(method.getDeclaringClass());
		return declaringClass;
	}

	public XModifier xgetModifiers() {
		// TODO Auto-generated method stub
		if(modifiers == null)
			modifiers = XFactoryImpl.get().xModifier(method.getModifiers());
		return modifiers;
	}
	
	public static XMethod xnew(Method method)
	{
		XMethod xmethod = new XMethodImpl(method);

		String name = method.getName();
		
		if(xmethods.containsKey(name))
		{
			ArrayList<XMethod> methods = xmethods.get(name);
			methods.add(xmethod);
		}
		else
		{
			ArrayList<XMethod> methods = new ArrayList<XMethod>();
			methods.add(xmethod);
			xmethods.put(name, methods);
		}
		return xmethod;
	}

	public XParameter[] xgetParameters() {
		// TODO Auto-generated method stub
		if(xparameters == null)
			initializeParameters();
		return xparameters;
	}

	public int xgetParameterCount() {
		// TODO Auto-generated method stub
		return method.getParameterCount();
	}

	public XClass[] xgetParameterTypes() {
		// TODO Auto-generated method stub
		if(xparameterTypes == null)
			initializeParameterTypes();
		return xparameterTypes;
	}
}
