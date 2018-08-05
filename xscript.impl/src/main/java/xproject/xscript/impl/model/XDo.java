package xproject.xscript.impl.model;

import xproject.xscript.impl.XConstants;

public class XDo extends XIterator {

	protected XDo(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xdo();
		try(XParameters xwhile = xgoto(xeval(), XConstants.WHILE))
		{
			boolean xif = XIf.xif(xwhile);
			while(xif)
			{
				xdo();
				xif = XIf.xif(xwhile.xclone());
			}
		}
		
	}
}
