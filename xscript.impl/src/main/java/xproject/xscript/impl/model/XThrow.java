package xproject.xscript.impl.model;

import xproject.xlang.XException;

public class XThrow extends XCommand {

	protected XThrow(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		try(XThisParameter xthis = new XThisParameter(xparameters()))
		{
			if(xthis.xthis() != null && xthis.xthis() instanceof XException)
			{
				((XException)xthis.xthis()).xthrow();
			}
		}
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return false;
	}

}
