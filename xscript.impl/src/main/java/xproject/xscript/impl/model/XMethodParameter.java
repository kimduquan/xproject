package xproject.xscript.impl.model;

import xproject.xlang.XClass;
import xproject.xlang.xreflect.XMethod;
import xproject.xrmi.XRemote;

public class XMethodParameter implements XRemote, AutoCloseable {

	private XParameters xparameters;
	private XClassParameter xclass;
	private XThisParameter xthis;
	private XMethod xmethod;
	
	public XMethodParameter(XParameters parameters, XClassParameter cls, XThisParameter ths)
	{
		xparameters = parameters;
		xclass = cls;
		xthis = ths;
		xmethod = null;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xparameters = null;
		xclass = null;
		xthis = null;
		xmethod = null;
		finalize();
	}
	
	public XMethod xmethod() throws Exception
	{
		if(xmethod == null)
		{
			XClass xtype = null;
			if(xthis.xthis() == null)
			{
				xtype = xclass.xclass();
			}
			else
			{
				xtype = xthis.xthis().xgetClass();
			}
			
			xmethod = xtype.xgetMethod(xparameters.xmethod(), xparameters.xparameterTypes());
		}
		return xmethod;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		try {
			xfinalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
