package xproject.xlang.xreflect.impl;

import java.lang.reflect.Array;

import xproject.xlang.XObject;
import xproject.xlang.impl.XObjectImpl;
import xproject.xlang.xreflect.XArray;

public class XArrayImpl extends XObjectImpl implements XArray {
	
	public XArrayImpl(Object object) {
		super(object);
	}

	public XObject xget(int index) {
		// TODO Auto-generated method stub
		XObject xobj = XObject.NULL;
		Object object = Array.get(get(), index);
		if(object != null)
		{
			if(object.getClass().isArray())
			{
				xobj = new XArrayImpl(object);
			}
			else
			{
				xobj = XObjectImpl.xnew(object);
			}
		}
		return xobj;
	}

	public void xset(int index, XObject object) {
		// TODO Auto-generated method stub
		if(object instanceof XObjectImpl) {
			XObjectImpl xobject = (XObjectImpl) object;
			Array.set(get(), index, xobject.get());
		}
	}

	public int xgetLength() {
		// TODO Auto-generated method stub
		return Array.getLength(get());
	}

}
