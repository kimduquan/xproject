package xproject.xutil.xconcurrent;

import java.util.concurrent.TimeUnit;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XExecutorService extends XRemote {

	boolean xawaitTermination(long timeout, TimeUnit unit) throws Exception;
	
	void xshutdown() throws Exception;
	
	XFuture xsubmit(XCallable task) throws Exception;
	
	XFuture xsubmit(XCallable task, XObject result) throws Exception;
	
	boolean xisTerminated() throws Exception;
	
	void xexecute(XRunnable command) throws Exception;
	
	XCallable[] xshutdownNow() throws Exception;
	
	XFuture[] xinvokeAll(XCallable[] tasks) throws Exception;
	
	XFuture[] xinvokeAll(XCallable[] tasks, long timeout, TimeUnit unit) throws Exception;
	
	XObject xinvokeAny(XCallable[] tasks) throws Exception;
	
	XObject xinvokeAny(XCallable[] tasks, long timeout, TimeUnit unit) throws Exception;
}
