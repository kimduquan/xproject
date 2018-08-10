package xproject.xscript.impl.model;

import xproject.xscript.impl.XConstants;

public class XWhile extends XIterator {

	private XLine xwhile;
	
	protected XWhile(XLine line, XEval eval) {
		super(line, eval, "");
		// TODO Auto-generated constructor stub
		xwhile = null;
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		while(xwhile())
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
			}
		}
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
