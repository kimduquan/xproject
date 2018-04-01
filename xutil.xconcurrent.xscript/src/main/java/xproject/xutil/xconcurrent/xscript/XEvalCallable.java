package xproject.xutil.xconcurrent.xscript;

import xproject.xutil.XScanner;
import xproject.xutil.xconcurrent.XCallable;

public interface XEvalCallable extends XCallable {

	String xreturn() throws Exception;
	
	XScanner xscanner() throws Exception;
}
