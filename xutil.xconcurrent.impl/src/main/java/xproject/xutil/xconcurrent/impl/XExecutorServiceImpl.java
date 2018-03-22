package xproject.xutil.xconcurrent.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import xproject.x.impl.XImpl;
import xproject.xlang.XObject;
import xproject.xutil.xconcurrent.XExecutorService;
import xproject.xutil.xconcurrent.XFuture;
import xproject.xutil.xconcurrent.XRunnable;
import xproject.xutil.xconcurrent.XCallable;
import xproject.xutil.xconcurrent.XConcurrentFactory;

public class XExecutorServiceImpl extends XImpl<XExecutorService, ExecutorService, XConcurrentFactory> implements XExecutorService {

	protected XExecutorServiceImpl(ExecutorService v) {
		super(v);
		// TODO Auto-generated constructor stub
	}

	public boolean xawaitTermination(long timeout, TimeUnit unit) throws Exception {
		// TODO Auto-generated method stub
		return x().awaitTermination(timeout, unit);
	}

	public void xshutdown() throws Exception {
		// TODO Auto-generated method stub
		x().shutdown();
	}

	public XFuture xsubmit(XCallable task) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean xisTerminated() throws Exception {
		// TODO Auto-generated method stub
		return x().isTerminated();
	}

	public void xexecute(XRunnable command) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public XCallable[] xshutdownNow() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XFuture[] xinvokeAll(XCallable[] tasks) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XFuture[] xinvokeAll(XCallable[] tasks, long timeout, TimeUnit unit) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XObject xinvokeAny(XCallable[] tasks) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XObject xinvokeAny(XCallable[] tasks, long timeout, TimeUnit unit) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XFuture xsubmit(XCallable task, XObject result) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
