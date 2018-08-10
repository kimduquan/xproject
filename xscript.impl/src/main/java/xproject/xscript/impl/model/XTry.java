package xproject.xscript.impl.model;

import xproject.xlang.XException;
import xproject.xscript.impl.XConstants;

public class XTry extends XCommand {
	
	protected XTry(XLine line, XEval eval) {
		super(line, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		XException xexception = null;
		try
		{
			xeval(xeval(), "");
		}
		catch(Exception ex)
		{
			xexception = xeval().xfactory().xException(ex);
			XLine xnextCatch = null;
			do
			{
				xnextCatch = xgoto(xeval(), XConstants.CATCH);
				if(xnextCatch != null)
				{
					try(XLine line = xnextCatch)
					{
						try(XCatch xcatch = new XCatch(line, xeval(), xexception))
						{
							xcatch.xrun();
							xexception = xcatch.xexception();
						}
					}
				}
				else
					break;
			}
			while(xexception != null);
			if(xexception != null)
			{
				try(XLine line = xgoto(xeval(), XConstants.FINALLY))
				{
					try(XFinally xfinally = new XFinally(line, xeval()))
					{
						xfinally.xrun();
					}
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
