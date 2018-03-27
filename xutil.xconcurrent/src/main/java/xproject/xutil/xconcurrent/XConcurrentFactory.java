package xproject.xutil.xconcurrent;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XConcurrentFactory extends XRemote {

	XObject xobject(XFuture xfuture) throws Exception;
}
