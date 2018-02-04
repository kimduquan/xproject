package xproject.xcr.observation;

import xproject.xcr.XRangeIterator;
import xproject.xrmi.XRemote;

public interface XEventListenerIterator extends XRangeIterator, XRemote {
	XEventListener xnextEventListener() throws Exception;
}
