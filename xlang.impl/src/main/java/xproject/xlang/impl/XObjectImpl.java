package xproject.xlang.impl;

import xproject.xlang.XClass;
import xproject.xlang.XObject;

public class XObjectImpl implements XObject{

	private XClass xclass;
	private Object object;
	
	protected XObjectImpl(Object object)
	{
		xclass = null;
		this.object = object;
	}
	
	
	
	public XClass xgetClass() {
		// TODO Auto-generated method stub
		if(xclass == null)
		{
			xclass = XClassImpl.xnew(object.getClass());
		}
		return xclass;
	}

	public Object x()
	{
		return object;
	}

	public String xtoString() {
		// TODO Auto-generated method stub
		return object.toString();
	}
	
	public static XObject xnew(Object object)
	{
		return new XObjectImpl(object);
	}



	public int xhashCode() {
		// TODO Auto-generated method stub
		return System.identityHashCode(object);
	}
}
