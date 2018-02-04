package xproject.xcr.xversion;

import xproject.xcr.XRangeIterator;
import xproject.xrmi.XRemote;

public interface XVersionIterator extends XRangeIterator, XRemote {
	XVersion xnextVersion() throws Exception;
}
