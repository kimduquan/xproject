package xproject.xagent;

import xproject.xrmi.XRemote;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xutil.XScanner;

public interface XAgent extends XRemote {

	String xgetName() throws Exception;
	XScanner xgetScanner() throws Exception;
	XScriptContext xgetScriptContext() throws Exception;
	XScriptEngine xgetScriptEngine() throws Exception;
}
