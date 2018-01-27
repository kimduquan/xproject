package xproject.xagent.xrmi.impl;

import xproject.xagent.XAgent;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xutil.XScanner;

public class XRemoteAgentImpl extends XUnicastRemoteObject<XAgent> implements XAgent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected XRemoteAgentImpl(XAgent ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public String xgetName() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetName();
	}

	public XScanner xgetScanner() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetScanner();
	}

	public XScriptContext xgetScriptContext() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetScriptContext();
	}

	public XScriptEngine xgetScriptEngine() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetScriptEngine();
	}

	public static XAgent xnew(XAgent ref) throws Exception
	{
		return new XRemoteAgentImpl(ref);
	}
}
