package xproject.xscript;

import xproject.util.XScanner;
import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XArray;

public interface XScriptEngineEx extends XScriptEngine {

	void ximport(XClass cls, XScanner scanner, XScriptContext context) throws Exception;
	XObject xnew(XClass cls, XScanner scanner, XScriptContext context) throws Exception;
	XObject xcatch(XClass exceptionType, XScanner scanner, XScriptContext context) throws Exception;
	boolean xif(XScanner scanner, XScriptContext context) throws Exception;
	void xwhile(XScanner scanner, XScriptContext context) throws Exception;
	void xfor(XArray array, XScanner scanner, XScriptContext context) throws Exception;
	void xbreak(XScanner scanner, XScriptContext context) throws Exception;
}
