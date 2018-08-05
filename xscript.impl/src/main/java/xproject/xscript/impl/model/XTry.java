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
		try
		{
			xeval(xeval(), "");
		}
		catch(Exception ex)
		{
			xexception = xeval().xfactory().xException(ex);
			do
			{
				try(XParameters parameters = xgoto(xeval(), XConstants.CATCH))
				{
					try(XCatch xcatch = new XCatch(parameters, xeval(), xexception))
					{
						xcatch.xrun();
						xexception = xcatch.xexception();
					}
				}
			}
			while(xexception != null);
		}
		finally
		{
			try(XParameters parameters = xgoto(xeval(), XConstants.FINALLY))
			{
				try(XFinally xfinally = new XFinally(parameters, xeval()))
				{
					xfinally.xrun();
				}
			}
		}
		
		if(xexception != null)
		{
			xexception.xthrow();
		}
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return true;
	}
}
