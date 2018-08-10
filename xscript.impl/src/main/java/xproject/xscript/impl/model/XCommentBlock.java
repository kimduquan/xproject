package xproject.xscript.impl.model;

import xproject.xscript.impl.XConstants;

public class XCommentBlock extends XCommand {

	protected XCommentBlock(XLine line, XEval eval) {
		super(line, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xgoto(xeval(), XConstants.COMMENT_BLOCK_END);
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return true;
	}

}
