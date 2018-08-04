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
			xif();
		}
		else
		{
			xelse();
		}
	}
	
	protected void xif() throws Exception
	{
		try(XEval xeval = XEval.xnew(xeval(), XConstants.ELSE))
		{
			xeval.xrun();
			if(xeval.xend() != null)
			{
				try(XCommand xelse = xeval.xend())
				{
					try(XGoto xgoto = XGoto.xnew(xeval(), XConstants.FINAL))
					{
						xgoto.xrun();
						if(xgoto.xline() != null)
						{
							try(XParameters p = xgoto.xline())
							{
								
							}
						}
					}
				}
			}
		}
	}
	
	protected void xelse() throws Exception
	{
		try(XGoto xgoto = XGoto.xnew(xeval(), XConstants.ELSE))
		{
			xgoto.xrun();
			if(xgoto.xline() != null)
			{
				try(XParameters parameters = xgoto.xline())
				{
					try(XElse xelse = new XElse(parameters, xeval()))
					{
						xelse.xrun();
					}
				}
			}
		}
	}

	public static boolean xif(XParameters xparameters) throws Exception
	{
		return false;
	}
}
