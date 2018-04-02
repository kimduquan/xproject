package xproject.xutil.xconcurrent.impl;

import java.util.concurrent.Callable;
import xproject.xlang.XObject;
import xproject.xutil.xconcurrent.XCallable;

public class CallableImpl implements Callable<XObject> {

	private XCallable xcallable;
	
	protected CallableImpl(XCallable callable)
	{
		xcallable = callable;
	}
	
	public XObject call() throws Exception {
		// TODO Auto-generated method stub
		return xcallable.xcall();
	}
	
	public static Callable<XObject> xnew(XCallable callable)
	{
		return new CallableImpl(callable);
	}
}
