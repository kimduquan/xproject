package xproject.xscript.impl.model;

import xproject.xlang.XObject;

public class XReturn extends XCommand {
	
	protected XReturn(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	private XObject xreturn;

	public XObject xreturn()
	{
		return xreturn;
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		String xthis = xparameters().xthis();
		if(xparameters().xeval().xbindings().xcontainsKey(xthis))
		{
			xreturn = xparameters().xeval().xbindings().xget(xthis);
		}
	}
}
