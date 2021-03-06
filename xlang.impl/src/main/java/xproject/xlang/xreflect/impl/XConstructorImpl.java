package xproject.xlang.xreflect.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XModifier;
import xproject.xlang.xreflect.XParameter;

public class XConstructorImpl implements XConstructor {

	private Constructor<?> constructor;
	private XModifier modifiers;
	private XParameter[] xparameters;
	private XClass[] xparameterTypes;
	private XClass declaringClass;
	private XFactory xfactory;
	
	protected XConstructorImpl(Constructor<?> c, XFactory xfactory)
	{
		constructor = c;
		modifiers = null;
		xparameters = null;
		xparameterTypes = null;
		declaringClass = null;
		this.xfactory = xfactory;
	}
	
	public static XConstructor xnew(Constructor<?> c, XFactory xfactory)
	{
		return new XConstructorImpl(c, xfactory);
	}
	
	protected void initializeParameters() throws Exception
	{
		Parameter[] parameters = constructor.getParameters();
		xparameters = new XParameter[parameters.length];
		for(int i = 0; i< parameters.length; i++)
		{
			xparameters[i] = xfactory.xParameter(parameters[i]);
		}
	}
	
	protected void initializeParameterTypes() throws Exception
	{
		Class<?>[] types = constructor.getParameterTypes();
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
			for(int i = 0; i< xparameters.length; i++)
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
			for(int i = 0; i< xparameterTypes.length; i++)
			{
				xfactory.xfinalize(xparameterTypes[i]);
			}
			xparameterTypes = null;
		}
	}
	public XClass xgetDeclaringClass() throws Exception {
		// TODO Auto-generated method stub
		if(declaringClass == null)
		declaringClass = xfactory.xClass(constructor.getDeclaringClass());
		return declaringClass;
	}

	public XModifier xgetModifiers() throws Exception {
		// TODO Auto-generated method stub
		if(modifiers == null)
			xfactory.xModifier(constructor.getModifiers());
		return modifiers;
	}

	public XParameter[] xgetParameters() throws Exception {
		// TODO Auto-generated method stub
		if(xparameters == null)
			initializeParameters();
		return xparameters;
	}

	public int xgetParameterCount() {
		// TODO Auto-generated method stub
		return constructor.getParameterCount();
	}

	public XClass[] xgetParameterTypes() throws Exception {
		// TODO Auto-generated method stub
		if(xparameterTypes == null)
			initializeParameterTypes();
		return xparameterTypes;
	}

	public XObject xnewInstance(XObject[] xobjects) throws Exception {
		// TODO Auto-generated method stub
		Object[] params = new Object[xobjects.length];
		for(int i = 0; i < params.length; i++)
		{
			params[i] = xobjects[i].x();
		}
		return xfactory.xObject(constructor.newInstance(params));
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		constructor = null;
		modifiers = null;
		xparameters = null;
		xparameterTypes = null;
		declaringClass = null;
		xfactory = null;
		finalize();
	}
}
