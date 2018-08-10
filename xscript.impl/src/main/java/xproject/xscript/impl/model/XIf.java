package xproject.xscript.impl.model;

import xproject.xscript.impl.XConstants;

public class XIf extends XCommand {

	protected XIf(XLine line, XEval eval) {
		super(line, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		try(XBooleanParameter xboolean = new XBooleanParameter(xLine()))
		{
			if(xboolean.xboolean(false))
			{
				XLine line = xeval(xeval(), XConstants.ELSE);
				if(line != null)
				{
					try(XCommand xelse = xeval().xcommandFactory().xcommand(XConstants.ELSE, xeval(), line))
					{
						xelse.xgoto(xeval(), "");
					}
				}
			}
			else
			{
				XLine line = xgoto(xeval(), XConstants.ELSE);
				if(line != null)
				{
					try(XCommand xelse = xeval().xcommandFactory().xcommand(XConstants.ELSE, xeval(), line))
					{
						xelse.xeval(xeval(), "");
					}
				}
			}
		}
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return true;
	}
}
