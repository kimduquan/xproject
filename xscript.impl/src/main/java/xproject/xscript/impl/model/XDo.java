package xproject.xscript.impl.model;

import xproject.xscript.impl.XConstants;

public class XDo extends XIterator {

	private XLine xwhile;
	
	protected XDo(XLine line, XEval eval) {
		super(line, eval, XConstants.WHILE);
		// TODO Auto-generated constructor stub
		xwhile = null;
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		do
		{
			try(XLine xstop = xdo())
			{
				if(xstop.xmethod().equals(XConstants.BREAK))
				{
					break;
				}
				else if(xstop.xmethod().equals(XConstants.CONTINUE))
				{
					continue;
				}
				else if(xstop.xmethod().equals(XConstants.WHILE))
				{
					xwhile = xstop;
				}
			}
		}
		while(xwhile());
	}
	
	protected boolean xwhile() throws Exception
	{
		boolean b = false;
		if(xwhile != null)
		{
			try(XBooleanParameter xboolean = new XBooleanParameter(xwhile))
			{
				b = xboolean.xboolean(false);
			}
		}
		return b;
	}
}
