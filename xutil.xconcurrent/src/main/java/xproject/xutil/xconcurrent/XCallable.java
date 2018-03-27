package xproject.xutil.xconcurrent;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XCallable extends XRemote {

	XObject xcall() throws Exception;
}
