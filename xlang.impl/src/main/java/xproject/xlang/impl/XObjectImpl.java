package xproject.xlang.impl;

import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;

public class XObjectImpl implements XObject{

	private XClass xclass;
	private Object object;
	private XFactory xfactory;
	
	protected XObjectImpl(Object object, XFactory factory)
	{
		xclass = null;
		this.object = object;
		xfactory = factory;
	}
	
	
	
	public XClass xgetClass() throws Exception 
	{
		// TODO Auto-generated method stub
		if(xclass == null)
		{
			xclass = xfactory.xClass(object.getClass());
		}
		return xclass;
	}

	public Object x() throws Exception
	{
		return object;
	}

	public String xtoString() {
		// TODO Auto-generated method stub
		return object.toString();
	}
	
	public static XObject xnew(Object object, XFactory xfactory)
	{
		return new XObjectImpl(object, xfactory);
	}



	public int xhashCode() {
		// TODO Auto-generated method stub
		return System.identityHashCode(object);
	}



	public void xfinalize() throws Exception {
		// TODO Auto-generated method stub
		try {
			finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
