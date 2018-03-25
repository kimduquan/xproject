package xproject.xscript.impl;

import xproject.xlang.XObject;
import xproject.xlang.xreflect.XMethod;
import xproject.xutil.xconcurrent.XRunnable;

public class XInvokeMethodRunnable implements XRunnable {

	private XMethod xmethod;
	private XObject xthis;
	private XObject[] xparameters;
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xmethod = null;
		xthis = null;
		xparameters = null;
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xmethod.xinvoke(xthis, xparameters);
	}
	protected XInvokeMethodRunnable(XMethod xmethod, XObject xthis, XObject[] xparameters)
	{
		this.xmethod = xmethod;
		this.xthis = xthis;
		this.xparameters = xparameters;
	}

	public static XRunnable xnew(XMethod xmethod, XObject xthis, XObject[] xparameters) throws Exception
	{
		return new XInvokeMethodRunnable(xmethod, xthis, xparameters);
	}
}
