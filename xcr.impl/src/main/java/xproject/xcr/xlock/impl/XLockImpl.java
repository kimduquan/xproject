package xproject.xcr.xlock.impl;

import javax.jcr.lock.Lock;

import xproject.xcr.XNode;
import xproject.xcr.impl.XCRImpl;
import xproject.xcr.impl.XFactory;
import xproject.xcr.xlock.XLock;

public class XLockImpl extends XCRImpl<XLock, Lock> implements XLock {

	protected XLockImpl(Lock lock, XFactory factory) {
		super(lock, factory);
		// TODO Auto-generated constructor stub
	}

	public String xgetLockOwner() throws Exception {
		// TODO Auto-generated method stub
		return x().getLockOwner();
	}

	public String xgetLockToken() throws Exception {
		// TODO Auto-generated method stub
		return x().getLockToken();
	}

	public XNode xgetNode() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNode(x().getNode());
	}

	public long xgetSecondsRemaining() throws Exception {
		// TODO Auto-generated method stub
		return x().getSecondsRemaining();
	}

	public boolean xisDeep() throws Exception {
		// TODO Auto-generated method stub
		return x().isDeep();
	}

	public boolean xisLive() throws Exception {
		// TODO Auto-generated method stub
		return x().isLive();
	}

	public boolean xisLockOwningSession() throws Exception {
		// TODO Auto-generated method stub
		return x().isLockOwningSession();
	}

	public boolean xisSessionScoped() throws Exception {
		// TODO Auto-generated method stub
		return x().isSessionScoped();
	}

	public void xrefresh() throws Exception {
		// TODO Auto-generated method stub
		x().refresh();
	}

}
