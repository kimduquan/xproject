package xproject.xdriver.impl;

import xproject.xdriver.XDriverMethod;
import xproject.xdriver.XDriverObject;
import xproject.xdriver.XDriverParameter;
import xproject.xdriver.XDriverReturn;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XMethod;

public class XDriverMethodImpl implements XDriverMethod {

	private XMethod xmethod;
	private XObject xobject;
	
	public XDriverMethodImpl(XMethod method, XObject object)
	{
		xmethod = method;
		xobject = object;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xmethod = null;
		xobject = null;
		finalize();
	}

	public XDriverReturn xset(XDriverParameter parameter) throws Exception {
		// TODO Auto-generated method stub
		xmethod.xinvoke(xobject, parameter.values());
		return new XDriverReturnImpl(null, null);
	}

	public XDriverReturn xget(XDriverParameter parameter) throws Exception {
		// TODO Auto-generated method stub
		XObject xreturn = xmethod.xinvoke(xobject, null);
		if(xreturn.xequals(XObject.xnull))
			return new XDriverReturnImpl(xmethod.xgetReturnType(), xreturn);
		else
			return new XDriverReturnImpl(xreturn.xgetClass(), xreturn);
	}

	public XDriverObject xvalue() throws Exception {
		// TODO Auto-generated method stub
		XObject xreturn = xmethod.xinvoke(xobject, null);
		if(xreturn.xequals(XObject.xnull) == false)
			return new XDriverObjectImpl(xreturn);
		return null;
	}

}
