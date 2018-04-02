package xproject.xutil.xconcurrent;

import xproject.xrmi.XRemote;

public interface XExecutors extends XRemote {

	XExecutorService xnewCachedThreadPool() throws Exception;
	
	XExecutorService xnewFixedThreadPool(int nThreads) throws Exception;
	
	XExecutorService xnewScheduledThreadPool(int corePoolSize) throws Exception;
	
	XExecutorService xnewSingleThreadExecutor() throws Exception;
}
