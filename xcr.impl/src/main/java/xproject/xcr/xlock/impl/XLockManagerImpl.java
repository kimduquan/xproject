package xproject.xcr.xlock.impl;

import javax.jcr.lock.LockManager;

import xproject.xcr.impl.XCRImpl;
import xproject.xcr.impl.XFactory;
import xproject.xcr.xlock.XLock;
import xproject.xcr.xlock.XLockManager;

public class XLockManagerImpl extends XCRImpl<XLockManager, LockManager> implements XLockManager {

	protected XLockManagerImpl(LockManager lockManager, XFactory factory) {
		super( lockManager, factory);
		// TODO Auto-generated constructor stub
	}

	public void xaddLockToken(String lockToken) throws Exception {
		// TODO Auto-generated method stub
		x().addLockToken(lockToken);
	}

	public XLock xgetLock(String absPath) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xLock(x().getLock(absPath));
	}

	public String[] xgetLockTokens() throws Exception {
		// TODO Auto-generated method stub
		return x().getLockTokens();
	}

	public boolean xholdsLock(String absPath) throws Exception {
		// TODO Auto-generated method stub
		return x().holdsLock(absPath);
	}

	public boolean xisLocked(String absPath) throws Exception {
		// TODO Auto-generated method stub
		return x().isLocked(absPath);
	}

	public XLock xlock(String absPath, boolean isDeep, boolean isSessionScoped, long timeoutHint, String ownerInfo)
			throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xLock(x().lock(absPath, isDeep, isSessionScoped, timeoutHint, ownerInfo));
	}

}
