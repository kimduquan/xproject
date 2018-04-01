package xproject.xutil.xconcurrent.xscript.impl;

import xproject.xlang.XObject;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptEngine;
import xproject.xutil.XScanner;
import xproject.xutil.xconcurrent.xscript.XEvalCallable;

public class XEvalCallableImpl implements XEvalCallable {

	private XScriptEngine xengine;
	private XScanner xscanner;
	private XBindings xbindings;
	private String xreturn;
	
	protected XEvalCallableImpl(XScriptEngine engine, XScanner scanner, XBindings bindings, String xreturn)
	{
		xengine = engine;
		xscanner = scanner;
		xbindings = bindings;
		this.xreturn = xreturn;
	}
	
	public XObject xcall() throws Exception {
		// TODO Auto-generated method stub
		return xengine.xeval(xscanner, xbindings);
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xengine = null;
		xscanner = null;
		xbindings = null;
		xreturn = null;
		finalize();
	}

	public String xreturn() throws Exception {
		// TODO Auto-generated method stub
		return xreturn;
	}

	public static XEvalCallable xnew(XScriptEngine engine, XScanner scanner, XBindings bindings, String xreturn) throws Exception
	{
		return new XEvalCallableImpl(engine, scanner, bindings, xreturn);
	}

	public XScanner xscanner() throws Exception {
		// TODO Auto-generated method stub
		return xscanner;
	}
}
