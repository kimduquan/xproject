package xproject.xlang.xreflect.impl;

import java.lang.reflect.Parameter;

import xproject.xlang.XClass;
import xproject.xlang.impl.XClassImpl;
import xproject.xlang.xreflect.XParameter;

public class XParameterImpl implements XParameter {

	private Parameter parameter;
	
	public XParameterImpl(Parameter p)
	{
		parameter = p;
	}

	public String xgetName() {
		// TODO Auto-generated method stub
		return parameter.getName();
	}

	public XClass xgetType() {
		// TODO Auto-generated method stub
		return XClassImpl.xnew(parameter.getType());
	}
	
	
}
