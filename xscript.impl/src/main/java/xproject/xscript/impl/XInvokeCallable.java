package xproject.xscript.impl;

import xproject.xutil.xconcurrent.XCallable;

public interface XInvokeCallable extends XCallable {

	String xreturn() throws Exception;
}
