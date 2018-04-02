package xproject.xutil.xconcurrent.xscript.impl;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xutil.xconcurrent.XFuture;
import xproject.xutil.xconcurrent.xscript.XFutureObject;

public class XFutureObjectImpl implements XFutureObject {

	private XFuture xfuture;
	
	protected XFutureObjectImpl(XFuture future)
	{
		xfuture = future;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xfuture.xget().xfinalize();
		xfuture = null;
		finalize();
	}

	public XClass xgetClass() throws Exception {
		// TODO Auto-generated method stub
		return xfuture.xget().xgetClass();
	}

	public String xtoString() throws Exception {
		// TODO Auto-generated method stub
		return xfuture.xget().xtoString();
	}

	public int xhashCode() throws Exception {
		// TODO Auto-generated method stub
		return xfuture.xget().xhashCode();
	}

	public Object x() throws Exception {
		// TODO Auto-generated method stub
		return xfuture.xget().x();
	}

	public boolean xequals(XObject xobject) throws Exception {
		// TODO Auto-generated method stub
		return xfuture.xget().xequals(xobject);
	}

	public XFuture xfuture() throws Exception {
		// TODO Auto-generated method stub
		return xfuture;
	}

	public static XFutureObject xnew(XFuture future)
	{
		return new XFutureObjectImpl(future);
	}
}
