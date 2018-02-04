package xproject.xcr.observation;

import xproject.xrmi.XRemote;

public interface XEventListener extends XRemote {
	void xonEvent(XEventIterator events) throws Exception;
}
