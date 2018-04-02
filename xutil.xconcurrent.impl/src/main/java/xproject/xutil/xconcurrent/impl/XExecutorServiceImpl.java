package xproject.xutil.xconcurrent.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import xproject.x.impl.XImpl;
import xproject.xlang.XObject;
import xproject.xlang.XRunnable;
import xproject.xutil.xconcurrent.XExecutorService;
import xproject.xutil.xconcurrent.XFuture;
import xproject.xutil.xconcurrent.XCallable;

public class XExecutorServiceImpl extends XImpl<XExecutorService, ExecutorService, Object> implements XExecutorService {

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
		Callable<XObject> call = CallableImpl.xnew(task);
		return XFutureImpl.xnew(x().submit(call));
	}

	public boolean xisTerminated() throws Exception {
		// TODO Auto-generated method stub
		return x().isTerminated();
	}

	public void xexecute(XRunnable command) throws Exception {
		// TODO Auto-generated method stub
		x().execute(RunnableImpl.xnew(command));
	}

	public XRunnable[] xshutdownNow() throws Exception {
		// TODO Auto-generated method stub
		List<Runnable> runs = x().shutdownNow();
		XRunnable[] xruns = new XRunnable[runs.size()];
		int i = 0;
		for(Runnable run : runs)
		{
			xruns[i] = ((RunnableImpl)run).x();
			i++;
		}
		return xruns;
	}

	public XFuture[] xinvokeAll(XCallable[] tasks) throws Exception {
		// TODO Auto-generated method stub
		List<Callable<XObject>> calls = new ArrayList<Callable<XObject>>();
		for(XCallable xcall : tasks)
		{
			calls.add(CallableImpl.xnew(xcall));
		}
		List<Future<XObject>> futures = x().invokeAll(calls);
		
		XFuture[] xfutures = new XFuture[futures.size()];
		int i = 0;
		for(Future<XObject> future : futures)
		{
			xfutures[i] = XFutureImpl.xnew(future);
			i++;
		}
		return xfutures;
	}

	public XFuture[] xinvokeAll(XCallable[] tasks, long timeout, TimeUnit unit) throws Exception {
		// TODO Auto-generated method stub
		List<Callable<XObject>> calls = new ArrayList<Callable<XObject>>();
		for(XCallable xcall : tasks)
		{
			calls.add(CallableImpl.xnew(xcall));
		}
		List<Future<XObject>> futures = x().invokeAll(calls, timeout, unit);
		
		XFuture[] xfutures = new XFuture[futures.size()];
		int i = 0;
		for(Future<XObject> future : futures)
		{
			xfutures[i] = XFutureImpl.xnew(future);
			i++;
		}
		return xfutures;
	}

	public XObject xinvokeAny(XCallable[] tasks) throws Exception {
		// TODO Auto-generated method stub
		List<Callable<XObject>> calls = new ArrayList<Callable<XObject>>();
		for(XCallable xcall : tasks)
		{
			calls.add(CallableImpl.xnew(xcall));
		}
		return x().invokeAny(calls);
	}

	public XObject xinvokeAny(XCallable[] tasks, long timeout, TimeUnit unit) throws Exception {
		// TODO Auto-generated method stub
		List<Callable<XObject>> calls = new ArrayList<Callable<XObject>>();
		for(XCallable xcall : tasks)
		{
			calls.add(CallableImpl.xnew(xcall));
		}
		return x().invokeAny(calls, timeout, unit);
	}

	public XFuture xsubmit(XRunnable task) throws Exception {
		// TODO Auto-generated method stub
		return XFutureImpl.xnew(x().submit(RunnableImpl.xnew(task)));
	}

	public XFuture xsubmit(XRunnable task, XObject result) throws Exception {
		// TODO Auto-generated method stub
		return XFutureImpl.xnew(x().submit(RunnableImpl.xnew(task), result));
	}
	
	public static XExecutorService xnew(ExecutorService executor) throws Exception
	{
		return new XExecutorServiceImpl(executor);
	}
}
