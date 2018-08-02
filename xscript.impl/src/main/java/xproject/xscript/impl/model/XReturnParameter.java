package xproject.xscript.impl.model;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xscript.XBindings;

public class XReturnParameter implements XRemote, AutoCloseable {

	private XParameters xparameters;
	
	public XReturnParameter(XParameters parameters)
	{
		xparameters = parameters;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xparameters = null;
		finalize();
	}
	
	public void xreturn(XObject xreturn) throws Exception
	{
		String name = xparameters.xreturn();
		XBindings xbindings = xparameters.xbindings();
		if(name.isEmpty() == false)
		{
			xbindings.xput(name, xreturn);
		}
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
