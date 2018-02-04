package xproject.xcr.observation;

import xproject.xrmi.XRemote;

public interface XEventJournal extends XEventIterator, XRemote {
	void xskipTo(long date) throws Exception;
}
