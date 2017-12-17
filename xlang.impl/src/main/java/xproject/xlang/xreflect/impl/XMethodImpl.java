package xproject.xlang.xreflect.impl;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import xproject.xlang.XClass;
import xproject.xlang.impl.XClassImpl;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XModifier;
import xproject.xlang.xreflect.XParameter;

public class XMethodImpl implements XMethod {

	private static HashMap<String, ArrayList<XMethod>> xmethods = new HashMap<String, ArrayList<XMethod>>();
	
	private Method method;
	private XModifier modifiers;
	private XParameter[] xparameters;
	private XClass[] xparameterTypes;
	
	private XMethodImpl(Method m)
	{
		method = m;
		modifiers = XModifierImpl.xnew(m.getModifiers());
		xparameters = null;
		xparameterTypes = null;
	}
	
	protected void initializeParameters()
	{
		ArrayList<XParameter> params = new ArrayList<XParameter>();
		for(Parameter p : method.getParameters())
		{
			params.add(XParameterImpl.xnew(p));
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
		for(Class<?> type : method.getParameterTypes())
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

	public String xgetName() {
		// TODO Auto-generated method stub
		return method.getName();
	}

	public XClass xgetDeclaringClass() {
		// TODO Auto-generated method stub
		try {
			return XClassImpl.xnew(method.getDeclaringClass());
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
