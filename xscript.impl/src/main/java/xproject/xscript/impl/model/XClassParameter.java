package xproject.xscript.impl.model;

import xproject.xlang.XClass;
import xproject.xrmi.XRemote;

public class XClassParameter implements XRemote, AutoCloseable {

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
			if(xparameters.xclass() != null)
			{
				if(xparameters.xeval().xclasses().containsKey(xparameters.xclass()))
				{
					xclass = xparameters.xeval().xclasses().get(xparameters.xclass());
				}
				else
				{
					xclass = xparameters.xeval().xclassLoader().xloadClass(xparameters.xclass());
				}
			}
		}
		return xclass;
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
