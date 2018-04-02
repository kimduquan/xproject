package xproject.xutil.xconcurrent.impl;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import xproject.x.impl.XImpl;
import xproject.xlang.XObject;
import xproject.xutil.xconcurrent.XFuture;

public class XFutureImpl extends XImpl<XFuture, Future<?>, Object> implements XFuture {

	protected XFutureImpl(Future<?> v) {
		super(v);
		// TODO Auto-generated constructor stub
	}

	public XObject xget() throws Exception {
		// TODO Auto-generated method stub
		return (XObject) x().get();
	}

	public boolean xcancel(boolean mayInterruptIfRunning) throws Exception {
		// TODO Auto-generated method stub
		return x().cancel(mayInterruptIfRunning);
	}

	public boolean xisDone() throws Exception {
		// TODO Auto-generated method stub
		return x().isDone();
	}

	public boolean xisCancelled() throws Exception {
		// TODO Auto-generated method stub
		return x().isCancelled();
	}

	public XObject xget(long timeout, TimeUnit unit) throws Exception {
		// TODO Auto-generated method stub
		return (XObject) x().get(timeout, unit);
	}

	public static XFuture xnew(Future<?> future)
	{
		return new XFutureImpl(future);
	}
}
