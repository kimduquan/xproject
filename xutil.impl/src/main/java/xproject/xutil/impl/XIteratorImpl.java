package xproject.xutil.impl;

import java.util.Iterator;

import xproject.xrmi.XRemote;
import xproject.xutil.XIterator;

public class XIteratorImpl<T extends XRemote> implements XIterator<T> {

	private Iterator<T> iterator;
	
	protected XIteratorImpl(Iterator<T> it)
	{
		iterator = it;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		iterator = null;
		finalize();
	}

	@Override
	public boolean xhasNext() throws Exception {
		// TODO Auto-generated method stub
		return iterator.hasNext();
	}

	@Override
	public T xnext() throws Exception {
		// TODO Auto-generated method stub
		return iterator.next();
	}

	@Override
	public void xremove() throws Exception {
		// TODO Auto-generated method stub
		iterator.remove();
	}

}
