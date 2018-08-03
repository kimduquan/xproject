package xproject.xscript.impl.model;

import xproject.xlang.XException;
import xproject.xscript.impl.XConstants;

public class XTry extends XCommand {

	protected XTry(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		try
		{
			xeval().xrun();
		}
		catch(Exception ex)
		{
			XException xexception = xeval().xfactory().xException(ex);
			xcatch(xexception);
		}
		finally
		{
			try(XGoto xgoto = new XGoto(xparameters(), xeval(), XConstants.FINALLY))
			{
				xgoto.xrun();
				try(XParameters parameters = xgoto.xgoto())
				{
					try(XFinally xfinally = new XFinally(parameters, xeval()))
					{
						xfinally.xrun();
					}
				}
			}
		}
	}
	
	protected void xcatch(XException xexception) throws Exception
	{
		boolean hasCatched = false;
		do
		{
			try(XGoto xgoto = new XGoto(xparameters(), xeval(), XConstants.CATCH))
			{
				xgoto.xrun();
				if(xgoto.xgoto() != null)
				{
					try(XParameters parameters = xgoto.xgoto())
					{
						try(XCatch xcatch = new XCatch(parameters, xeval(), xexception))
						{
							xcatch.xrun();
							if(xcatch.xexception() != null)
							{
								hasCatched = true;
							}
						}
					}
				}
				else
					break;
			}
		}
		while(!hasCatched);
		if(!hasCatched)
		{
			xexception.xthrow();
		}
	}
}
