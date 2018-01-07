package xproject.xscript.xrmi.impl;

import xproject.xlang.XObject;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;

public class XRemoteScriptContextImpl extends XUnicastRemoteObject<XScriptContext> implements XScriptContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected XRemoteScriptContextImpl(XScriptContext ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public XObject xgetAttribute(String name) throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetAttribute(name);
	}

	public XBindings xgetBindings(int scope) throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetBindings(scope);
	}

	public static XScriptContext xnew(XScriptContext ref) throws Exception
	{
		return new XRemoteScriptContextImpl(ref);
	}
}
