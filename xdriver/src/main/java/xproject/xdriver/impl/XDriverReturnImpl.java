package xproject.xdriver.impl;

import xproject.xdriver.XDriverReturn;
import xproject.xlang.XClass;
import xproject.xlang.XObject;

public class XDriverReturnImpl implements XDriverReturn {

	private XObject xobject;
	private XClass xclass;
	
	public XDriverReturnImpl(XClass cls, XObject object)
	{
		xclass = cls;
		xobject = object;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xclass = null;
		xobject = null;
		finalize();
	}

	public XClass xclass() throws Exception {
		// TODO Auto-generated method stub
		return xclass;
	}

	public XObject xobject() throws Exception {
		// TODO Auto-generated method stub
		return xobject;
	}

}
