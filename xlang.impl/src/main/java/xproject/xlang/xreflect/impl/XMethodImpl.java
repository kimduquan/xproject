package xproject.xlang.xreflect.impl;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
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
	private XFactory xfactory;
	
	protected XMethodImpl(Method m, XFactory xfactory)
	{
		method = m;
		modifiers = null;
		xparameters = null;
		xparameterTypes = null;
		declaringClass = null;
		this.xfactory = xfactory;
	}
	
	protected void initializeParameters() throws Exception
	{
		Parameter[] params = method.getParameters();
		xparameters = new XParameter[params.length];
		for(int i = 0; i < params.length; i++)
		{
			xparameters[i] = xfactory.xParameter(params[i]);
		}
	}
	
	protected void initializeParameterTypes() throws Exception
	{
		Class<?>[] types = method.getParameterTypes();
		xparameterTypes = new XClass[types.length];
		for(int i = 0; i < types.length; i++)
		{
			xparameterTypes[i] = xfactory.xClass(types[i]);
		}
	}
	
	protected void uninitializeParameters() throws Exception
	{
		if(xparameters != null)
		{
			for(int i = 0; i < xparameters.length; i++)
			{
				xfactory.xfinalize(xparameters[i]);
			}
			xparameters = null;
		}
	}
	
	protected void uninitializeParameterTypes() throws Exception
	{
		if(xparameterTypes != null)
		{
			for(int i = 0; i < xparameterTypes.length; i++)
			{
				xfactory.xfinalize(xparameterTypes[i]);
			}
			xparameterTypes = null;
		}
	}

	public String xgetName() {
		// TODO Auto-generated method stub
		return method.getName();
	}

	public XClass xgetDeclaringClass() throws Exception {
		// TODO Auto-generated method stub
		if(declaringClass == null)
			declaringClass = xfactory.xClass(method.getDeclaringClass());
		return declaringClass;
	}

	public XModifier xgetModifiers() throws Exception {
		// TODO Auto-generated method stub
		if(modifiers == null)
			modifiers = xfactory.xModifier(method.getModifiers());
		return modifiers;
	}
	
	public static XMethod xnew(Method method, XFactory xfactory)
	{
		XMethod xmethod = new XMethodImpl(method, xfactory);

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

	public XParameter[] xgetParameters() throws Exception {
		// TODO Auto-generated method stub
		if(xparameters == null)
			initializeParameters();
		return xparameters;
	}

	public int xgetParameterCount() {
		// TODO Auto-generated method stub
		return method.getParameterCount();
	}

	public XClass[] xgetParameterTypes() throws Exception {
		// TODO Auto-generated method stub
		if(xparameterTypes == null)
			initializeParameterTypes();
		return xparameterTypes;
	}

	public XObject xinvoke(XObject xobject, XObject[] xparameters)  throws Exception
	{
		// TODO Auto-generated method stub
		Object[] params = new Object[xparameters.length];
		for(int i = 0; i< params.length; i++)
		{
			params[i] = xparameters[i].x();
		}
		return xfactory.xObject(method.invoke(xobject.x(), params));
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		method = null;
		
		if(modifiers != null)
		{
			xfactory.xfinalize(modifiers);
			modifiers = null;
		}
		
		uninitializeParameters();
		uninitializeParameterTypes();

		if(declaringClass != null)
		{
			xfactory.xfinalize(declaringClass);
			declaringClass = null;
		}
		
		xfactory = null;
		finalize();
	}
}
