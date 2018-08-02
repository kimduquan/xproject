package xproject.xscript.impl.model;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XConstructor;

public class XNew extends XCommand {

	public XNew(XParameters parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xparameters().xclass();
		xparameters().xreturn();
		xparameters().xparameters();
		try(XClassParameter xclass = new XClassParameter(xparameters()))
		{
			try(XReturnParameter xreturn = new XReturnParameter(xparameters()))
			{
				XClass cls = xclass.xclass();
				XConstructor xconstructor = cls.xgetConstructor(xparameters().xparameterTypes());
				XObject xnew = xconstructor.xnewInstance(xparameters().xparameters());
				xreturn.xreturn(xnew);
			}
		}
	}
}
