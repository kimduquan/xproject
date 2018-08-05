package xproject.xscript.impl.model;

import xproject.xlang.XObject;

public class XInvoke extends XCommand {

	protected XInvoke(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		try(XClassParameter xclass = new XClassParameter(xparameters()))
		{
			try(XThisParameter xthis = new XThisParameter(xparameters()))
			{
				try(XMethodParameter xmethod = new XMethodParameter(xparameters(), xclass, xthis))
				{
					if(xmethod.xmethod() != null)
					{
						XObject xobject = xmethod.xmethod().xinvoke(xthis.xthis(), xparameters().xparameters());
						try(XReturnParameter xreturn = new XReturnParameter(xparameters()))
						{
							xreturn.xreturn(xobject);
						}
					}
				}
			}
		}
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
