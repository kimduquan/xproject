package xproject.xscript;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xutil.XScanner;

public interface XScriptEngine extends XRemote {

	XBindings xcreateBindings() throws Exception;
	
	XObject xeval(XScanner xscanner, XBindings xbindings) throws Exception;
	
	XObject xeval(XScanner xscanner, XScriptContext xcontext) throws Exception;
	
	XObject xeval(XScanner xscanner) throws Exception;
	
	XObject xeval(String script, XBindings xbindings) throws Exception;
	
	XObject xeval(String script, XScriptContext xcontext) throws Exception;
	
	XObject xeval(String script) throws Exception;
}
