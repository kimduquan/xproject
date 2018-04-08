package xproject.xscript.impl;

import xproject.xlang.XObject;
import xproject.xutil.xconcurrent.XFuture;

public interface XFutureObject extends XObject {

	XFuture xfuture() throws Exception;
}
