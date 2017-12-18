package xproject.xlang.xreflect.impl;

import java.lang.reflect.Array;
import xproject.xlang.XObject;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xlang.impl.XObjectImpl;
import xproject.xlang.xreflect.XArray;

public class XArrayImpl extends XObjectImpl implements XArray {
	
	protected XArrayImpl(Object object) 
	{
		super(object);
	}

	public XObject xget(int index) {
		// TODO Auto-generated method stub
		Object obj = Array.get(x(), index);
		return XFactoryImpl.get().xObject(obj);
	}

	public void xset(int index, XObject xobject) {
		// TODO Auto-generated method stub
		Array.set(x(), index, xobject.x());
	}

	public int xgetLength() {
		// TODO Auto-generated method stub
		return Array.getLength(x());
	}
	
	public static XArray xnew(Object object)
	{
		return new XArrayImpl(object);
	}
}
