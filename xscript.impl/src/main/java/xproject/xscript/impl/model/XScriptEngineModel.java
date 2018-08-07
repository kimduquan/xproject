package xproject.xscript.impl.model;

import xproject.xlang.XClassLoader;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xutil.XScanner;

public class XScriptEngineModel implements XScriptEngine {

	private XFactory xfactory;
	private XCommandFactory xcommandFactory;
	private XClassLoader xclassLoader;
	
	public XScriptEngineModel(XFactory factory, XCommandFactory commandFactory, XClassLoader classLoader)
	{
		xfactory = factory;
		xcommandFactory = commandFactory;
		xclassLoader = classLoader;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xfactory = null;
		xcommandFactory = null;
		xclassLoader = null;
	}

	@Override
	public XBindings xcreateBindings() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XObject xeval(XScanner xscanner, XBindings xbindings) throws Exception {
		// TODO Auto-generated method stub
		XObject xreturn = null;
		try(XEval xeval = new XEval(xcommandFactory, xfactory, xclassLoader, "", 0))
		{
			xeval.xscanner(xscanner);
			xeval.xbindings(xbindings);
			xeval.run();
			xreturn = xeval.xreturn();
		}
		return xreturn;
	}

	@Override
	public XObject xeval(XScanner xscanner, XScriptContext xcontext) throws Exception {
		// TODO Auto-generated method stub
		XObject xreturn = null;
		try(XEval xeval = new XEval(xcommandFactory, xfactory, xclassLoader, "", 0))
		{
			xeval.xscanner(xscanner);
			xeval.xscriptContext(xcontext);
			xeval.run();
			xreturn = xeval.xreturn();
		}
		return xreturn;
	}

	@Override
	public XObject xeval(XScanner xscanner) throws Exception {
		// TODO Auto-generated method stub
		XObject xreturn = null;
		try(XEval xeval = new XEval(xcommandFactory, xfactory, xclassLoader, "", 0))
		{
			xeval.xscanner(xscanner);
			xeval.run();
			xreturn = xeval.xreturn();
		}
		return xreturn;
	}

	@Override
	public XObject xeval(String script, XBindings xbindings) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XObject xeval(String script, XScriptContext xcontext) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XObject xeval(String script) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
