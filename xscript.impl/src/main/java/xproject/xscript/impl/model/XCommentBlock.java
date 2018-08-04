package xproject.xscript.impl.model;

import xproject.xscript.impl.XConstants;

public class XCommentBlock extends XCommand {

	protected XCommentBlock(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		try(XGoto xgoto = XGoto.xnew(xeval(), XConstants.COMMENT_BLOCK_END))
		{
			xgoto.xrun();
			if(xgoto.xline() != null)
			{
				try(XParameters parameters = xgoto.xline())
				{
					
				}
			}
		}
	}

}
