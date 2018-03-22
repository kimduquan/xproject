package xproject.xcr.xobservation;

import xproject.xrmi.XRemote;

public interface XEventListener extends XRemote {
	void xonEvent(XEventIterator events) throws Exception;
}
