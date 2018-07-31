package xproject.xscript.impl.model;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XConstructor;
import xproject.xrmi.XRemote;

public class XNew implements XRemote {

private XParameters xparameters;
	
	public XNew(XParameters parameters)
	{
		xparameters = parameters;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xparameters = null;
		finalize();
	}

	public void xnew() throws Exception
	{
		xparameters.xclass();
		xparameters.xreturn();
		xparameters.xparameters();
		try(XAutoCloseableImpl<XClassParameter> xclass = new XAutoCloseableImpl<XClassParameter>(new XClassParameter(xparameters)))
		{
			try(XAutoCloseableImpl<XReturnParameter> xreturn = new XAutoCloseableImpl<XReturnParameter>(new XReturnParameter(xparameters)))
			{
				XClass cls = xclass.x().xclass();
				XConstructor xconstructor = cls.xgetConstructor(xparameters.xparameterTypes());
				XObject xnew = xconstructor.xnewInstance(xparameters.xparameters());
				xreturn.x().xreturn(xnew);
			}
		}
	}
}
