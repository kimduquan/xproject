package xproject.xlang.xreflect.impl;

import java.lang.reflect.Parameter;

import xproject.xlang.XClass;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xlang.xreflect.XParameter;

public class XParameterImpl implements XParameter {

	private Parameter parameter;
	private XClass type;
	
	protected XParameterImpl(Parameter p)
	{
		parameter = p;
		type = null;
	}

	public String xgetName() {
		// TODO Auto-generated method stub
		return parameter.getName();
	}

	public XClass xgetType() {
		// TODO Auto-generated method stub
		if(type == null)
			type = XFactoryImpl.get().xClass(parameter.getType());
		return type;
	}
	
	public static XParameter xnew(Parameter p)
	{
		return new XParameterImpl(p);
	}
}
