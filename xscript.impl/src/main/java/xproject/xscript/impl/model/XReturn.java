package xproject.xscript.impl.model;

import xproject.xlang.XObject;

public class XReturn extends XCommand {
	
	private XObject xreturn;

	public XReturn(XParameters parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
		xreturn = null;
	}

	public XObject xreturn()
	{
		return xreturn;
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		String xthis = xparameters().xthis();
		if(xparameters().xbindings().xcontainsKey(xthis))
		{
			xreturn = xparameters().xbindings().xget(xthis);
		}
	}
}
