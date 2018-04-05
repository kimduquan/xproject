package xproject.xscript.impl;

import xproject.xrmi.XRemote;
import xproject.xutil.XScanner;

public interface XLine extends XRemote {

	XScanner xscanner() throws Exception;
	long xnumber() throws Exception;
}
