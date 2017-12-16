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
	
	
	
	@Override
	public XClass xgetClass() {
		// TODO Auto-generated method stub
		if(xclass == null)
		{
			try {
				xclass = XClassImpl.xnew(object.getClass());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return xclass;
	}

	public Object get()
	{
		return object;
	}

	@Override
	public String xtoString() {
		// TODO Auto-generated method stub
		return object.toString();
	}
	
	public static XObject xnew(Object object)
	{
		if(object == null)
			return XObject.NULL;
		return new XObjectImpl(object);
	}



	@Override
	public int xhashCode() {
		// TODO Auto-generated method stub
		return System.identityHashCode(object);
	}
}
