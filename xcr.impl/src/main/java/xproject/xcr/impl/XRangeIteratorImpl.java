package xproject.xcr.impl;

import javax.jcr.RangeIterator;

import xproject.xcr.XRangeIterator;

public abstract class XRangeIteratorImpl implements XRangeIterator{

	private RangeIterator iterator;
	
	protected XRangeIteratorImpl(RangeIterator it)
	{
		iterator = it;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		iterator = null;
		finalize();
	}

	public long xgetPosition() throws Exception {
		// TODO Auto-generated method stub
		return iterator.getPosition();
	}

	public long xgetSize() throws Exception {
		// TODO Auto-generated method stub
		return iterator.getSize();
	}

	public void xskip(long skipNum) throws Exception {
		// TODO Auto-generated method stub
		iterator.skip(skipNum);
	}

	public boolean xhasNext() throws Exception {
		// TODO Auto-generated method stub
		return iterator.hasNext();
	}

	public void xremove() throws Exception {
		// TODO Auto-generated method stub
		iterator.remove();
	}
}
