package xproject.xlang.xreflect.impl;

import java.lang.reflect.Array;

import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xlang.impl.XObjectImpl;
import xproject.xlang.xreflect.XArray;

public class XArrayImpl extends XObjectImpl implements XArray {
	
	private XFactory xfactory;
	
	protected XArrayImpl(Object object, XFactory xfactory) 
	{
		super(object, xfactory);
		this.xfactory = xfactory;
	}

	public XObject xget(int index) throws Exception
	{
		// TODO Auto-generated method stub
		Object obj = Array.get(x(), index);
		return xfactory.xObject(obj);
	}

	public void xset(int index, XObject xobject) throws Exception
	{
		// TODO Auto-generated method stub
		Array.set(x(), index, xobject.x());
	}

	public int xgetLength() throws Exception
	{
		// TODO Auto-generated method stub
		return Array.getLength(x());
	}
	
	public static XArray xnew(Object object, XFactory xfactory)
	{
		return new XArrayImpl(object, xfactory);
	}
}
