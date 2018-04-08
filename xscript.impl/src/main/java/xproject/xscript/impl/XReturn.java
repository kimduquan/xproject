package xproject.xscript.impl;

import xproject.xlang.XRunnable;
import xproject.xscript.XBindings;

public class XReturn implements XRunnable 
{
	private XEval xeval;
	private XLine xline;
	private XBindings xbindings;
	
	protected XReturn(XEval eval, XLine line, XBindings bindings)
	{
		xeval = eval;
		xline = line;
		xbindings = bindings;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xline = null;
		xeval = null;
		xbindings = null;
	}

	public void xrun() throws Exception 
	{
		if(xline.xhasNextParam(XConstants.THIS))
		{
			xeval.xreturn(xline.xnextObjectParam(xbindings));
		}
		xeval.xfinal();
	}
}
