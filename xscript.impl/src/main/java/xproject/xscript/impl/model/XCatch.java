package xproject.xscript.impl.model;

import xproject.xlang.XException;

public class XCatch extends XCommand {

	protected XCatch(XLine line, XEval eval, XException exception) {
		super(line, eval);
		// TODO Auto-generated constructor stub
		xexception = exception;
	}

	private XException xexception;

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		//xeval().xscriptContext().xgetErrorWriter().xwrite(xexception.xgetMessage());
		try(XClassParameter xclass = new XClassParameter(xLine()))
		{
			if(xclass.xclass() != null)
			{
				if(xclass.xclass().xisAssignableFrom(xexception.xgetClass()))
				{
					try(XReturnParameter xreturn = new XReturnParameter(xLine()))
					{
						xreturn.xreturn(xexception);
						xexception = null;
						xeval(xeval(), "");
						return;
					}
				}
			}
			else
			{
				try(XReturnParameter xreturn = new XReturnParameter(xLine()))
				{
					xreturn.xreturn(xexception);
					xexception = null;
					xeval(xeval(), "");
					return;
				}
			}
		}
		xgoto(xeval(), "");
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public XException xexception()
	{
		return xexception;
	}
}
