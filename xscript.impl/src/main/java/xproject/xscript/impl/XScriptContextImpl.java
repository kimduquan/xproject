package xproject.xscript.impl;

import xproject.xlang.XObject;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;

public class XScriptContextImpl implements XScriptContext {

	private XBindings engine;
	private XBindings global;
	
	protected XScriptContextImpl(XBindings e, XBindings g)
	{
		engine = e;
		global = g;
	}
	
	public XObject xgetAttribute(String name) throws Exception {
		// TODO Auto-generated method stub
		return XObject.xnull;
	}

	public XBindings xgetBindings(int scope) throws Exception {
		// TODO Auto-generated method stub
		if(scope == XScriptContext.XENGINE_SCOPE)
			return engine;
		if(scope == XScriptContext.XGLOBAL_SCOPE)
			return global;
		
		return null;
	}
	
	public static XScriptContext xnew()
	{
		XBindings e = XBindingsImpl.xnew();
		XBindings g = XBindingsImpl.xnew();
		return new XScriptContextImpl(e, g);
	}
}
