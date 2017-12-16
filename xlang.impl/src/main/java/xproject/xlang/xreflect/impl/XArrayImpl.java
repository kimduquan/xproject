package xproject.xlang.xreflect.impl;

import java.lang.reflect.Array;

import xproject.xlang.XObject;
import xproject.xlang.impl.XObjectImpl;
import xproject.xlang.xreflect.XArray;

public class XArrayImpl extends XObjectImpl implements XArray {

	private XObject[] xobjects;
	
	public XArrayImpl(Object object) {
		super(object);
		// TODO Auto-generated constructor stub
		xobjects = new XObject[Array.getLength(object)];
		for(int i = 0; i < xobjects.length; i++)
		{
			xobjects[i] = null;
		}
	}

	public XObject xget(int index) {
		// TODO Auto-generated method stub
		if(xobjects[index] == null)
		{
			Object object = Array.get(get(), index);
			if(object == null)
				xobjects[index] = XObject.NULL;
			else
			{
				if(object.getClass().isArray())
				{
					xobjects[index] = new XArrayImpl(object);
				}
				else
				{
					xobjects[index] = XObjectImpl.xnew(object);
				}
			}
		}
		return xobjects[index];
	}

	public void xset(int index, XObject object) {
		// TODO Auto-generated method stub
		if(object instanceof XObjectImpl) {
			XObjectImpl xobject = (XObjectImpl) object;
			Array.set(get(), index, xobject.get());
			xobjects[index] = object;
		}
	}

	public int xgetLength() {
		// TODO Auto-generated method stub
		return Array.getLength(get());
	}

}
