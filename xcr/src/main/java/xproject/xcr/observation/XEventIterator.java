package xproject.xcr.observation;

import xproject.xcr.XRangeIterator;
import xproject.xrmi.XRemote;

public interface XEventIterator extends XRangeIterator, XRemote {
	XEvent xnextEvent() throws Exception;
}
