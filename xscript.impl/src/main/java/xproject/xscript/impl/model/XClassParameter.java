package xproject.xscript.impl.model;

import xproject.xlang.XClass;
import xproject.xrmi.XRemote;

public class XClassParameter implements XRemote {

	private XParameters xparameters;
	private XClass xclass;
	
	public XClassParameter(XParameters parameters)
	{
		xparameters = parameters;
		xclass = null;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xparameters = null;
		xclass = null;
		finalize();
	}

	public XClass xclass() throws Exception
	{
		if(xclass == null)
		{
			xclass = xparameters.xclassLoader().xloadClass(xparameters.xclass());
		}
		return xclass;
	}
}
