package xproject.xscript.impl;

import xproject.xlang.XRunnable;

public class XTry implements XRunnable {

	private XEval xeval;
	
	protected XTry(XEval eval)
	{
		xeval = eval;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xeval = null;
		finalize();
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		try
		{
			xeval.xrun();
		}
		catch(Exception ex)
		{
		}
	}

}
