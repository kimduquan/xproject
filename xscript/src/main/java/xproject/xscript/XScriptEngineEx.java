package xproject.xscript;

import xproject.xlang.XException;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XArray;
import xproject.xutil.XScanner;

public interface XScriptEngineEx extends XScriptEngine {

	//
	XObject xeval(String method, XScanner currentLine, XScanner scanner, XScriptContext context) throws Exception;
	
	//
	XObject xinvoke(String method, XScanner currentLine, XScriptContext context) throws Exception;
	
	//
	void ximport(XScanner currentLine) throws Exception;
	
	//
	XObject xnew(XScanner currentLine, XScriptContext context) throws Exception;
	
	//
	void xtry(XScanner scanner, XScriptContext context) throws Exception;
	
	//
	XObject xcatch(XException exception, XScanner currentLine, XScanner scanner, XScriptContext context) throws Exception;
	
	XScanner xgoto(XScanner scanner) throws Exception;
	
	boolean xif(XScanner currentLine, XScanner scanner, XScriptContext context) throws Exception;
	void xelse(XScanner scanner, XScriptContext context) throws Exception;
	//void xwhile(XScanner scanner, XScriptContext context) throws Exception;
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
	public static final String DO = "do";
}
