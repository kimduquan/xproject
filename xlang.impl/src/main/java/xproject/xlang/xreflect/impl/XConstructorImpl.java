package xproject.xlang.xreflect.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

import xproject.xlang.XClass;
import xproject.xlang.impl.XClassImpl;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XModifier;
import xproject.xlang.xreflect.XParameter;

public class XConstructorImpl implements XConstructor {

	private Constructor<?> constructor;
	private XModifier modifiers;
	private XParameter[] xparameters;
	private XClass[] xparameterTypes;
	
	protected XConstructorImpl(Constructor<?> c)
	{
		constructor = c;
		modifiers = new XModifierImpl(c.getModifiers());
		initializeParameters();
		initializeParameterTypes();
	}
	
	public static XConstructor xnew(Constructor<?> c)
	{
		return new XConstructorImpl(c);
	}
	
	protected void initializeParameters()
	{
		ArrayList<XParameter> params = new ArrayList<XParameter>();
		for(Parameter p : constructor.getParameters())
		{
			params.add(new XParameterImpl(p));
		}
		xparameters = new XParameter[params.size()];
		int i = 0;
		for(XParameter p : params)
		{
			xparameters[i] = p;
			i++;
		}
	}
	
	protected void initializeParameterTypes()
	{
		ArrayList<XClass> xclasses = new ArrayList<XClass>();
		for(Class<?> type : constructor.getParameterTypes())
		{
			xclasses.add(XClassImpl.xnew(type));
		}
		xparameterTypes = new XClass[xclasses.size()];
		int i = 0;
		for(XClass xtype : xclasses)
		{
			xparameterTypes[i] = xtype;
			i++;
		}
	}

	public XClass xgetDeclaringClass() {
		// TODO Auto-generated method stub
		try {
			return XClassImpl.xnew(constructor.getDeclaringClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public XModifier xgetModifiers() {
		// TODO Auto-generated method stub
		return modifiers;
	}

	public XParameter[] xgetParameters() {
		// TODO Auto-generated method stub
		return xparameters;
	}

	public int xgetParameterCount() {
		// TODO Auto-generated method stub
		return constructor.getParameterCount();
	}

	public XClass[] xgetParameterTypes() {
		// TODO Auto-generated method stub
		return xparameterTypes;
	}
}
