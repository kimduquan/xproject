package xproject.xscript.impl;

import xproject.xlang.XObject;
import xproject.xscript.XBindings;

public class XEvalTaskImpl implements XEvalTask {

	private XEngine xengine;
	private XScript xscript;
	private XBindings xbindings;
	private XContext xcontext;
	private XObject xobject;
	
	protected XEvalTaskImpl(XEngine engine, XScript script, XBindings bindings, XContext context)
	{
		xobject = null;
		xengine = engine;
		xbindings = bindings;
		xcontext = context;
	}
	
	@Override
	public XObject xcall() throws Exception {
		// TODO Auto-generated method stub
		xeval();
		return xobject;
	}

	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xengine = null;
		xscript = null;
		xbindings = null;
		xcontext = null;
		xobject = null;
		finalize();
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xeval();
	}

	protected void xeval() throws Exception
	{
		xobject = xengine.xeval(xscript, xbindings, xcontext);
	}
	
	public static XEvalTask xnew(XEngine engine, XScript script, XBindings bindings, XContext context)
	{
		return new XEvalTaskImpl(engine, script, bindings, context);
	}
}
