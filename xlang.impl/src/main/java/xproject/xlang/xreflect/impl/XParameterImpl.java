package xproject.xlang.xreflect.impl;

import java.lang.reflect.Parameter;

import xproject.xlang.XClass;
import xproject.xlang.impl.XFactory;
import xproject.xlang.xreflect.XParameter;

public class XParameterImpl implements XParameter {

	private Parameter parameter;
	private XClass type;
	private XFactory xfactory;
	
	protected XParameterImpl(Parameter p, XFactory xfactory)
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
			type = xfactory.xClass(parameter.getType());
		return type;
	}
	
	public static XParameter xnew(Parameter p, XFactory xfactory)
	{
		return new XParameterImpl(p, xfactory);
	}
}
