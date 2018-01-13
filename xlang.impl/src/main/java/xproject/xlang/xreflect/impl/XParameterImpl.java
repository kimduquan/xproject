package xproject.xlang.xreflect.impl;

import java.lang.reflect.Parameter;

import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xlang.xreflect.XParameter;

public class XParameterImpl implements XParameter {

	private Parameter parameter;
	private XClass type;
	private XFactory xfactory;
	
	protected XParameterImpl(Parameter p, XFactory xfactory)
	{
		parameter = p;
		type = null;
		this.xfactory = xfactory;
	}

	public String xgetName() {
		// TODO Auto-generated method stub
		return parameter.getName();
	}

	public XClass xgetType() throws Exception {
		// TODO Auto-generated method stub
		if(type == null)
			type = xfactory.xClass(parameter.getType());
		return type;
	}
	
	public static XParameter xnew(Parameter p, XFactory xfactory)
	{
		return new XParameterImpl(p, xfactory);
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		parameter = null;
		type = null;
		xfactory = null;
		finalize();
	}
}
