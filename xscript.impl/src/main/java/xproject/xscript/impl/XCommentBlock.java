package xproject.xscript.impl;

import xproject.xlang.XObject;

public class XCommentBlock extends XFunctionBlockImpl {

	protected XCommentBlock(XFunctionImpl parent, XArguments arguments) {
		super(null, parent, arguments);
		// TODO Auto-generated constructor stub
	}

	@Override
	public XObject xapply(XObject t) throws Exception {
		// TODO Auto-generated method stub
		xgoto(XConstants.COMMENT_BLOCK_END);
		return t;
	}

	
}
