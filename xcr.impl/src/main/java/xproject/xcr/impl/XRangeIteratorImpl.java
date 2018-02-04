package xproject.xcr.impl;

import javax.jcr.RangeIterator;

import xproject.xcr.XRangeIterator;

public abstract class XRangeIteratorImpl<R extends XRangeIterator, V extends RangeIterator> extends XCRImpl<R, V> implements XRangeIterator{

	protected XRangeIteratorImpl(V iterator)
	{
		super(iterator);
	}
	
	protected XRangeIteratorImpl(V iterator, XFactory factory)
	{
		super(iterator, factory);
	}

	public long xgetPosition() throws Exception {
		// TODO Auto-generated method stub
		return x().getPosition();
	}

	public long xgetSize() throws Exception {
		// TODO Auto-generated method stub
		return x().getSize();
	}

	public void xskip(long skipNum) throws Exception {
		// TODO Auto-generated method stub
		x().skip(skipNum);
	}

	public boolean xhasNext() throws Exception {
		// TODO Auto-generated method stub
		return x().hasNext();
	}

	public void xremove() throws Exception {
		// TODO Auto-generated method stub
		x().remove();
	}
}
