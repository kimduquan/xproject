package xproject.xscript;

import xproject.util.XScanner;
import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XArray;

public interface XScriptEngineEx extends XScriptEngine {

	//
	XObject xeval(String method, XScanner scanner, XScanner inLineScanner, XScriptContext context) throws Exception;
	
	//
	XObject xinvoke(String method, XScanner inLineScanner, XScriptContext context) throws Exception;
	
	//
	void ximport(XClass xclass) throws Exception;
	void ximport(XScanner inLineScanner, XScriptContext context) throws Exception;
	
	//
	XObject xnew(XScanner scanner, XScriptContext context) throws Exception;
	
	//
	void xtry(XScanner scanner, XScriptContext context) throws Exception;
	
	//
	//XObject xcatch(XScanner scanner, XScriptContext context) throws Exception;
	
	boolean xif(XScanner scanner, XScriptContext context) throws Exception;
	boolean xelse(XScanner scanner, XScriptContext context) throws Exception;
	void xwhile(XScanner scanner, XScriptContext context) throws Exception;
	void xbreak(XScanner scanner, XScriptContext context) throws Exception;
	
	//
	void xfor(XArray array, XScanner scanner, XScriptContext context) throws Exception;
	
	//
	XObject xreturn(XScanner scanner, XScriptContext context) throws Exception;
	//XObject xreturn(String name, XObject xobject, XScriptContext context) throws Exception;
	
	public static final String IMPORT = "import";
	public static final String NEW = "new";
	public static final String TRY = "try";
	public static final String CATCH = "catch";
	public static final String IF = "if";
	public static final String ELSE = "else";
	public static final String WHILE = "while";
	public static final String BREAK = "break";
	public static final String FOR = "for";
	public static final String RETURN = "return";
}
