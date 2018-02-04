package xproject.xcr.xlock;

import xproject.xrmi.XRemote;

public interface XLockManager extends XRemote {
	void xaddLockToken(String lockToken) throws Exception;
	XLock xgetLock(String absPath) throws Exception;
	String[] xgetLockTokens() throws Exception;
	boolean xholdsLock(String absPath) throws Exception;
	boolean xisLocked(String absPath) throws Exception;
	XLock xlock(String absPath, boolean isDeep, boolean isSessionScoped, long timeoutHint, String ownerInfo) throws Exception;
}
