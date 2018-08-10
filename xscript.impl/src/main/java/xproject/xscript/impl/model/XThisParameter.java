package xproject.xscript.impl.model;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xscript.XBindings;
import xproject.xscript.impl.XFutureObject;

public class XThisParameter implements XRemote, AutoCloseable {

	private XLine xline;
	private XObject xthis;
	
	public XThisParameter(XLine line)
	{
		xline = line;
		xthis = null;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xline = null;
		xthis = null;
		finalize();
	}

	public XObject xthis() throws Exception
	{
		if(xthis == null)
		{
			XBindings xbindings = xline.xeval().xbindings();
			if(xline.xthis() != null && xbindings.xcontainsKey(xline.xthis()))
			{
				xthis = xbindings.xget(xline.xthis());
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
