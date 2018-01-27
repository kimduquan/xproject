package xproject.xscript;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xutil.XScanner;

public interface XScriptEngine extends XRemote {

	XObject xeval(XScanner xscanner, XScriptContext xcontext) throws Exception;
	
	XObject xeval(XScanner xscanner) throws Exception;
}
