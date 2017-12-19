package xproject.xscript;

import xproject.util.XScanner;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XScriptEngine extends XRemote {

	XObject xeval(XScanner reader, XScriptContext context) throws Exception;
}
