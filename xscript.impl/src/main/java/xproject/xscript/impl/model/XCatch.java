package xproject.xscript.impl.model;

import xproject.xlang.XException;

public class XCatch extends XCommand {

	protected XCatch(XParameters parameters, XEval eval, XException exception) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
		xexception = exception;
	}

	private XException xexception;

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xeval().xscriptContext().xgetErrorWriter().xwrite(xexception.xgetMessage());
		try(XClassParameter xclass = new XClassParameter(xparameters()))
		{
			if(xclass.xclass() != null)
			{
				if(xclass.xclass().xisAssignableFrom(xexception.xgetClass()))
				{
					try(XReturnParameter xreturn = new XReturnParameter(xparameters()))
					{
						xreturn.xreturn(xexception);
						xeval().xrun();
						return;
					}
				}
			}
			else
			{
				try(XReturnParameter xreturn = new XReturnParameter(xparameters()))
				{
					xreturn.xreturn(xexception);
					xeval().xrun();
					return;
				}
			}
		}
		xexception = null;
	}
	
	public XException xexception()
	{
		return xexception;
	}
}
