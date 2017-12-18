package xproject.xlang.xreflect.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import xproject.xlang.XClass;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XModifier;
import xproject.xlang.xreflect.XParameter;

public class XConstructorImpl implements XConstructor {

	private Constructor<?> constructor;
	private XModifier modifiers;
	private XParameter[] xparameters;
	private XClass[] xparameterTypes;
	private XClass declaringClass;
	
	protected XConstructorImpl(Constructor<?> c)
	{
		constructor = c;
		modifiers = null;
		xparameters = null;
		xparameterTypes = null;
		declaringClass = null;
	}
	
	public static XConstructor xnew(Constructor<?> c)
	{
		return new XConstructorImpl(c);
	}
	
	protected void initializeParameters()
	{
		Parameter[] parameters = constructor.getParameters();
		xparameters = new XParameter[parameters.length];
		for(int i = 0; i< parameters.length; i++)
		{
			xparameters[i] = XFactoryImpl.get().xParameter(parameters[i]);
		}
	}
	
	protected void initializeParameterTypes()
	{
		Class<?>[] types = constructor.getParameterTypes();
		xparameterTypes = new XClass[types.length];
		for(int i = 0; i < types.length; i++)
		{
			xparameterTypes[i] = XFactoryImpl.get().xClass(types[i]);
		}
	}

	public XClass xgetDeclaringClass() {
		// TODO Auto-generated method stub
		if(declaringClass == null)
		declaringClass = XFactoryImpl.get().xClass(constructor.getDeclaringClass());
		return declaringClass;
	}

	public XModifier xgetModifiers() {
		// TODO Auto-generated method stub
		if(modifiers == null)
			XFactoryImpl.get().xModifier(constructor.getModifiers());
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
}
