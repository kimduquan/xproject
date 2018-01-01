package xproject.xlang.xreflect.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.impl.XFactory;
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
	
	protected void initializeParameters()
	{
		Parameter[] parameters = constructor.getParameters();
		xparameters = new XParameter[parameters.length];
		for(int i = 0; i< parameters.length; i++)
		{
			xparameters[i] = xfactory.xParameter(parameters[i]);
		}
	}
	
	protected void initializeParameterTypes()
	{
		Class<?>[] types = constructor.getParameterTypes();
		xparameterTypes = new XClass[types.length];
		for(int i = 0; i < types.length; i++)
		{
			xparameterTypes[i] = xfactory.xClass(types[i]);
		}
	}

	public XClass xgetDeclaringClass() {
		// TODO Auto-generated method stub
		if(declaringClass == null)
		declaringClass = xfactory.xClass(constructor.getDeclaringClass());
		return declaringClass;
	}

	public XModifier xgetModifiers() {
		// TODO Auto-generated method stub
		if(modifiers == null)
			xfactory.xModifier(constructor.getModifiers());
		return modifiers;
	}

	public XParameter[] xgetParameters() {
		// TODO Auto-generated method stub
		if(xparameters == null)
			initializeParameters();
		return xparameters;
	}

	public int xgetParameterCount() {
		// TODO Auto-generated method stub
		return constructor.getParameterCount();
	}

	public XClass[] xgetParameterTypes() {
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
}
