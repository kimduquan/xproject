package xproject.xscript.impl;

import xproject.xlang.XObject;

public class XReturn extends XFunctionImpl {

	private XFunctionBlockImpl xblock;
	
	protected XReturn(XFunctionFactory factory, XFunctionBlockImpl parent, XArguments arguments) {
		super(factory, parent, arguments);
		// TODO Auto-generated constructor stub
		xblock = parent;
	}

	@Override
	public XObject xapply(XObject t) throws Exception {
		// TODO Auto-generated method stub
		xblock.xreturn(null);
		return t;
	}

}
