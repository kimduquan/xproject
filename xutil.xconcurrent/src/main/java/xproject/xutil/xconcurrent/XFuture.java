package xproject.xutil.xconcurrent;

import java.util.concurrent.TimeUnit;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XFuture extends XRemote {

	XObject xget() throws Exception;
	
	boolean xcancel(boolean mayInterruptIfRunning) throws Exception;
	
	boolean xisDone() throws Exception;
	
	boolean xisCancelled() throws Exception;
	
	XObject xget(long timeout, TimeUnit unit) throws Exception;
	
	Object x() throws Exception;
}
