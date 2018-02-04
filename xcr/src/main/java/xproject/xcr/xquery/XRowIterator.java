package xproject.xcr.xquery;

import xproject.xcr.XRangeIterator;
import xproject.xrmi.XRemote;

public interface XRowIterator extends XRangeIterator, XRemote {
	XRow xnextRow() throws Exception;
}
