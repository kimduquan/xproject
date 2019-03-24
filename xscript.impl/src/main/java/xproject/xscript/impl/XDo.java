package xproject.xscript.impl;

import java.util.ArrayList;
import java.util.Iterator;

import xproject.xlang.XObject;

public class XDo extends XFunctionBlockImpl {
	
	private boolean xcontinue;
	private boolean xbreak;
	private Iterator<XArguments> iterator;
	private ArrayList<XArguments> functions;

	protected XDo(XFunctionImpl parent, XArguments arguments) {
		super(null, parent, arguments);
		// TODO Auto-generated constructor stub
		xcontinue = false;
		xbreak = false;
		iterator = null;
		functions = new ArrayList<XArguments>();
	}

	@Override
	public XObject xapply(XObject t) throws Exception {
		// TODO Auto-generated method stub
		return xeval(t, XConstants.WHILE);
	}

	public void xcontinue() throws Exception
	{
		xcontinue = true;
		iterator = functions.iterator();
	}
	
	public void xbreak() throws Exception
	{
		xbreak = true;
	}
}
