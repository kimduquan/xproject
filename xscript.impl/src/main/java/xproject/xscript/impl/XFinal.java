package xproject.xscript.impl;

import xproject.xlang.XObject;

public class XFinal extends XFunctionImpl {

	private XFunctionBlockImpl xblock;
	
	protected XFinal(XFunctionFactory factory, XFunctionBlockImpl parent, XArguments arguments) {
		super(factory, parent, arguments);
		// TODO Auto-generated constructor stub
		xblock = parent;
	}

	@Override
	public XObject xapply(XObject t) throws Exception {
		// TODO Auto-generated method stub
		xblock.xfinal();
		return t;
	}

}
