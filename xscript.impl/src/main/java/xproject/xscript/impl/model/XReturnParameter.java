package xproject.xscript.impl.model;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xscript.XBindings;
import xproject.xscript.impl.XConstants;

public class XReturnParameter implements XRemote, AutoCloseable {

	private XLine xline;
	
	public XReturnParameter(XLine line)
	{
		xline = line;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xline = null;
		finalize();
	}
	
	public void xreturn(XObject xreturn) throws Exception
	{
		XBindings xbindings = xline.xeval().xbindings();
		if(xline.xreturn() != null)
		{
			if(xline.xreturn().equals(XConstants.NULL) == false)
			{
				xbindings.xput(xline.xreturn(), xreturn);
			}
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
