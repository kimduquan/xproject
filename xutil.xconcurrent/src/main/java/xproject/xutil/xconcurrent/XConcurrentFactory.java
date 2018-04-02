package xproject.xutil.xconcurrent;

import xproject.xrmi.XRemote;

public interface XConcurrentFactory extends XRemote {

	XExecutors xExecutors() throws Exception;
}
