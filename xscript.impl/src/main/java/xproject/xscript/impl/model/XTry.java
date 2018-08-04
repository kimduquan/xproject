package xproject.xscript.impl.model;

import xproject.xlang.XException;
import xproject.xscript.impl.XConstants;

public class XTry extends XCommand {

	private XException xexception;
	
	protected XTry(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
		xexception = null;
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		boolean hasCatched = false;
		try
		{
			xeval().xrun();
		}
		catch(Exception ex)
		{
			xexception = xeval().xfactory().xException(ex);
			hasCatched = xcatch();
		}
		finally
		{
			xfinally();
		}
		if(hasCatched == false && xexception == null)
		{
			xexception.xthrow();
		}
	}
	
	protected boolean xcatch() throws Exception
	{
		boolean hasCatched = false;
		XParameters xnextCatch = null;
		do
		{
			xnextCatch = xeval().xgoto(XConstants.CATCH);
			if(xnextCatch != null)
			{
				try(XParameters parameters = xnextCatch)
				{
					try(XCatch xcatch = new XCatch(parameters, xeval(), xexception))
					{
						xcatch.xrun();
					}
				}
			}
		}
		while(!hasCatched && xnextCatch != null);
		return hasCatched;
	}
	
	protected void xfinally() throws Exception
	{
		XParameters parameters = xeval().xgoto(XConstants.FINALLY);
		if(parameters != null)
		{
			try(XFinally xfinally = new XFinally(parameters, xeval()))
			{
				xfinally.xrun();
			}
		}
	}
}
