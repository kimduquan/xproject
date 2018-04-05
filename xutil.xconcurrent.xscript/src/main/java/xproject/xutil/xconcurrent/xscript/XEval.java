package xproject.xutil.xconcurrent.xscript;

import xproject.xlang.XRunnable;
import xproject.xutil.XScanner;
import xproject.xutil.xconcurrent.XCallable;

public interface XEval extends XCallable, XRunnable {

	String xreturn() throws Exception;
	
	XScanner xscanner() throws Exception;
}
