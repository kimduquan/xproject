package xproject.xscript.impl.model;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public class XReturn implements XRemote {

	private XParameters xparameters;
	
	public XReturn(XParameters parameters)
	{
		xparameters = parameters;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xparameters = null;
		finalize();
	}

	public XObject xreturn() throws Exception
	{
		String xthis = xparameters.xthis();
		if(xparameters.xbindings().xcontainsKey(xthis))
		{
			return xparameters.xbindings().xget(xthis);
		}
		return null;
	}
}
