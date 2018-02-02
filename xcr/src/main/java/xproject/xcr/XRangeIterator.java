package xproject.xcr;

import xproject.xrmi.XRemote;
import xproject.xutil.XIterator;

public interface XRangeIterator extends XRemote, XIterator<XRemote> {
	long xgetPosition() throws Exception;
	long xgetSize() throws Exception;
	void xskip(long skipNum) throws Exception;
}
