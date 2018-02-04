package xproject.xcr.impl;

import javax.jcr.Binary;

import xproject.xcr.XBinary;

public class XBinaryImpl extends XCRImpl<XBinary, Binary> implements XBinary {

	protected XBinaryImpl(Binary b)
	{
		super(b);
	}

	public void xdispose() throws Exception {
		// TODO Auto-generated method stub
		x().dispose();
	}

	public long xgetSize() throws Exception {
		// TODO Auto-generated method stub
		return x().getSize();
	}

	public int xread(byte[] b, long position) throws Exception {
		// TODO Auto-generated method stub
		return x().read(b, position);
	}

}
