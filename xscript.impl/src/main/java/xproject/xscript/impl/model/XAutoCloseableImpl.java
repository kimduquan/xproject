package xproject.xscript.impl.model;

import xproject.xlang.XFactory;
import xproject.xrmi.XRemote;

public class XAutoCloseableImpl<T extends XRemote> implements AutoCloseable {

	private T xremote;
	
	public XAutoCloseableImpl(T remote)
	{
		xremote = remote;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		try {
			xremote.xfinalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xremote = null;
	}
	
	public T x() throws Exception
	{
		return xremote;
	}
}
