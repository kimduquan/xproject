package xproject.xutil.xconcurrent.impl;

import java.util.concurrent.Executors;

import xproject.xutil.xconcurrent.XExecutorService;
import xproject.xutil.xconcurrent.XExecutors;

public class XExecutorsImpl implements XExecutors {

	protected XExecutorsImpl()
	{
		
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		finalize();
	}

	public XExecutorService xnewCachedThreadPool() throws Exception {
		// TODO Auto-generated method stub
		return XExecutorServiceImpl.xnew(Executors.newCachedThreadPool());
	}

	public XExecutorService xnewFixedThreadPool(int nThreads) throws Exception {
		// TODO Auto-generated method stub
		return XExecutorServiceImpl.xnew(Executors.newFixedThreadPool(nThreads));
	}

	public XExecutorService xnewScheduledThreadPool(int corePoolSize) throws Exception {
		// TODO Auto-generated method stub
		return XExecutorServiceImpl.xnew(Executors.newScheduledThreadPool(corePoolSize));
	}

	public XExecutorService xnewSingleThreadExecutor() throws Exception {
		// TODO Auto-generated method stub
		return XExecutorServiceImpl.xnew(Executors.newSingleThreadExecutor());
	}

	public static XExecutors xnew()
	{
		return new XExecutorsImpl();
	}
}
