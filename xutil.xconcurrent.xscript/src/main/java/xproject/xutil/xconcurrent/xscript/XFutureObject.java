package xproject.xutil.xconcurrent.xscript;

import xproject.xlang.XObject;
import xproject.xutil.xconcurrent.XFuture;

public interface XFutureObject extends XObject {

	XFuture xfuture() throws Exception;
}
