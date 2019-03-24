package xproject.xscript.impl;

import xproject.xlang.XObject;

public class XAssert extends XFunctionImpl {

	public XAssert(XFunctionImpl parent, XArguments xargs) {
		super(null, parent, xargs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public XObject xapply(XObject t) throws Exception {
		// TODO Auto-generated method stub
		try(XBooleanArgument arg = new XBooleanArgument(xarguments()))
		{
			assert(arg.xboolean(false));
		}
		return t;
	}

}
