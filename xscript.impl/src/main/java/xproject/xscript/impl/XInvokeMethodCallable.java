package xproject.xscript.impl;

import xproject.xlang.XObject;
import xproject.xlang.xreflect.XMethod;

public class XInvokeMethodCallable implements XInvokeCallable {

	private XMethod xmethod;
	private XObject xthis;
	private XObject[] xparameters;
	private String xreturn;
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xmethod = null;
		xthis = null;
		xparameters = null;
		xreturn = null;
		finalize();
	}

	@Override
	public XObject xcall() throws Exception {
		// TODO Auto-generated method stub
		return xmethod.xinvoke(xthis, xparameters);
	}
	
	protected XInvokeMethodCallable(XMethod xmethod, XObject xthis, XObject[] xparameters, String xreturn)
	{
		this.xmethod = xmethod;
		this.xthis = xthis;
		this.xparameters = xparameters;
		this.xreturn = xreturn;
	}

	public static XInvokeCallable xnew(XMethod xmethod, XObject xthis, XObject[] xparameters, String xreturn) throws Exception
	{
		return new XInvokeMethodCallable(xmethod, xthis, xparameters, xreturn);
	}

	@Override
	public String xreturn() throws Exception {
		// TODO Auto-generated method stub
		return xreturn;
	}
}
