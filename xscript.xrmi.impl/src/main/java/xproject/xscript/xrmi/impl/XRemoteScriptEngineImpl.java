package xproject.xscript.xrmi.impl;

import xproject.xlang.XObject;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xutil.XScanner;

public class XRemoteScriptEngineImpl extends XUnicastRemoteObject<XScriptEngine> implements XScriptEngine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected XRemoteScriptEngineImpl(XScriptEngine ref) throws Exception
	{
		super(ref);
	}
	
	public XObject xeval(XScanner reader, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		return ref().xeval(reader, context);
	}

	public static XScriptEngine xnew(XScriptEngine ref) throws Exception
	{
		return new XRemoteScriptEngineImpl(ref);
	}

	public XObject xeval(XScanner xscanner) throws Exception {
		// TODO Auto-generated method stub
		return ref().xeval(xscanner);
	}

	public XBindings xcreateBindings() throws Exception {
		// TODO Auto-generated method stub
		return ref().xcreateBindings();
	}

	public XObject xeval(XScanner xscanner, XBindings xbindings) throws Exception {
		// TODO Auto-generated method stub
		return ref().xeval(xscanner, xbindings);
	}

	public XObject xeval(String script, XBindings xbindings) throws Exception {
		// TODO Auto-generated method stub
		return ref().xeval(script, xbindings);
	}

	public XObject xeval(String script, XScriptContext xcontext) throws Exception {
		// TODO Auto-generated method stub
		return ref().xeval(script, xcontext);
	}

	public XObject xeval(String script) throws Exception {
		// TODO Auto-generated method stub
		return ref().xeval(script);
	}
}
