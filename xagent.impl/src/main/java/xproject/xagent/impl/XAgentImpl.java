package xproject.xagent.impl;

import xproject.xagent.XAgent;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xutil.XScanner;

public class XAgentImpl implements XAgent {

	private XScanner xscanner;
	private XScriptContext xscriptContext;
	private XScriptEngine xscriptEngine;
	private String xname;
	
	protected XAgentImpl(String name, XScriptEngine xengine, XScriptContext xcontext, XScanner scanner)
	{
		xscanner = scanner;
		xscriptContext = xcontext;
		xscriptEngine = xengine;
		xname = name;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xscanner = null;
		xscriptContext = null;
		xscriptEngine = null;
		xname = null;
		finalize();
	}

	public String xgetName() throws Exception {
		// TODO Auto-generated method stub
		return xname;
	}

	public XScanner xgetScanner() throws Exception {
		// TODO Auto-generated method stub
		return xscanner;
	}

	public XScriptContext xgetScriptContext() throws Exception {
		// TODO Auto-generated method stub
		return xscriptContext;
	}

	public XScriptEngine xgetScriptEngine() throws Exception {
		// TODO Auto-generated method stub
		return xscriptEngine;
	}

	public static XAgent xnew(String name, XScriptEngine xengine, XScriptContext xcontext, XScanner scanner)
	{
		return new XAgentImpl(name, xengine, xcontext, scanner);
	}
}
