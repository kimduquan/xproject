package xproject.xcr;

import xproject.xrmi.XRemote;

public interface XBinary extends XRemote {
	void xdispose() throws Exception;
	long xgetSize() throws Exception;
	int xread(byte[] b, long position) throws Exception;
}
