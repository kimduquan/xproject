package xproject.xscript.impl.model;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xscript.XBindings;
import xproject.xscript.impl.XFutureObject;

public class XThisParameter implements XRemote, AutoCloseable {

	private XParameters xparameters;
	private XObject xthis;
	
	public XThisParameter(XParameters parameters)
	{
		xparameters = parameters;
		xthis = null;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xparameters = null;
		xthis = null;
		finalize();
	}

	public XObject xthis() throws Exception
	{
		if(xthis == null)
		{
			XBindings xbindings = xparameters.xeval().xbindings();
			if(xparameters.xthis() != null && xbindings.xcontainsKey(xparameters.xthis()))
			{
				xthis = xbindings.xget(xparameters.xthis());
				if(xthis != null)
				{
					if(xthis instanceof XFutureObject)
					{
						xthis = ((XFutureObject)xthis).xfuture().xget();
					}
				}
			}
		}
		return xthis;
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
