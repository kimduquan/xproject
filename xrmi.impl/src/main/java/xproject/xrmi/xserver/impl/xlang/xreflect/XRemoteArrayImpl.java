package xproject.xrmi.xserver.impl.xlang.xreflect;

import xproject.xlang.XObject;
import xproject.xlang.xreflect.XArray;
import xproject.xrmi.xserver.impl.xlang.XRemoteObjectImpl;

public class XRemoteArrayImpl extends XRemoteObjectImpl implements XArray {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XRemoteArrayImpl(XArray ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public XObject xget(int index) throws Exception {
		// TODO Auto-generated method stub
		return ((XArray)ref()).xget(index);
	}

	public void xset(int index, XObject object) throws Exception {
		// TODO Auto-generated method stub
		((XArray)ref()).xset(index, object);
	}

	public int xgetLength() throws Exception {
		// TODO Auto-generated method stub
		return ((XArray)ref()).xgetLength();
	}

}
