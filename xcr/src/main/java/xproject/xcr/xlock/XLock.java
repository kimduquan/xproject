package xproject.xcr.xlock;

import xproject.xcr.XNode;
import xproject.xrmi.XRemote;

public interface XLock extends XRemote {
	String xgetLockOwner() throws Exception;
	String xgetLockToken() throws Exception;
	XNode xgetNode() throws Exception;
	long xgetSecondsRemaining() throws Exception;
	boolean xisDeep() throws Exception;
	boolean xisLive() throws Exception;
	boolean xisLockOwningSession() throws Exception;
	boolean xisSessionScoped() throws Exception;
	void xrefresh() throws Exception;
}
