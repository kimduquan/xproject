package xproject.xscript.impl.model;

import xproject.xscript.impl.XConstants;

public class XIf extends XCommand {

	protected XIf(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		if(xif(xparameters()))
		{
			XParameters parameters = xeval(xeval(), XConstants.ELSE);
			if(parameters != null)
			{
				try(XCommand xelse = xeval().xcommandFactory().xcommand(XConstants.ELSE, xeval(), parameters))
				{
					xelse.xgoto(xeval(), "");
				}
			}
		}
		else
		{
			XParameters parameters = xgoto(xeval(), XConstants.ELSE);
			if(parameters != null)
			{
				try(XCommand xelse = xeval().xcommandFactory().xcommand(XConstants.ELSE, xeval(), parameters))
				{
					xelse.xeval(xeval(), "");
				}
			}
		}
	}

	public static boolean xif(XParameters xparameters) throws Exception
	{
		return false;
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return true;
	}
}
