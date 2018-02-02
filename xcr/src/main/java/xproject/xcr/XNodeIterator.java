package xproject.xcr;

import xproject.xrmi.XRemote;

public interface XNodeIterator extends XRemote, XRangeIterator {

	XNode xnextNode() throws Exception;
}
