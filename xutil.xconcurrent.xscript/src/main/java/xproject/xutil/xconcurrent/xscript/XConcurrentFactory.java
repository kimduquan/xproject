package xproject.xutil.xconcurrent.xscript;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xutil.xconcurrent.XFuture;

public interface XConcurrentFactory extends XRemote {

	XObject xobject(XFuture xobject) throws Exception;
}
