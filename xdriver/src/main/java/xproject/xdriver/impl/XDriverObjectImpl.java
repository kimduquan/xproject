package xproject.xdriver.impl;

import xproject.xdriver.XDriverClass;
import xproject.xdriver.XDriverObject;
import xproject.xdriver.XDriverReturn;
import xproject.xlang.XObject;

public class XDriverObjectImpl implements XDriverObject {

	private XObject xobject;
	
	public XDriverObjectImpl(XObject object)
	{
		xobject = object;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xobject = null;
		finalize();
	}

	public XDriverReturn xfinal() throws Exception {
		// TODO Auto-generated method stub
		try {
			xobject.xfinalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public XDriverClass xclass() throws Exception {
		// TODO Auto-generated method stub
		return new XDriverClassImpl(xobject.xgetClass(), xobject);
	}

}
