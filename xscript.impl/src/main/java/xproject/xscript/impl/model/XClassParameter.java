package xproject.xscript.impl.model;

import xproject.xlang.XClass;
import xproject.xrmi.XRemote;

public class XClassParameter implements XRemote, AutoCloseable {

	private XLine xline;
	private XClass xclass;
	
	public XClassParameter(XLine line)
	{
		xline = line;
		xclass = null;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xline = null;
		xclass = null;
		finalize();
	}

	public XClass xclass() throws Exception
	{
		if(xclass == null)
		{
			if(xline.xclass() != null)
			{
				if(xline.xeval().xclasses().containsKey(xline.xclass()))
				{
					xclass = xline.xeval().xclasses().get(xline.xclass());
				}
				else
				{
					xclass = xline.xeval().xclassLoader().xloadClass(xline.xclass());
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
