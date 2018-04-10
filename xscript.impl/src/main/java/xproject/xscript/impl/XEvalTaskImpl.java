package xproject.xscript.impl;

import xproject.xlang.XObject;

public class XEvalTaskImpl implements XEvalTask {

	private XEngine xengine;
	private XScript xscript;
	private XBinding xbinding;
	private XContext xcontext;
	private XObject xobject;
	
	protected XEvalTaskImpl(XEngine engine, XScript script, XBinding binding, XContext context)
	{
		xobject = null;
		xengine = engine;
		xbinding = binding;
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
		xbinding = null;
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
		xobject = xengine.xeval(xscript, xbinding, xcontext);
	}
	
	public static XEvalTask xnew(XEngine engine, XScript script, XBinding binding, XContext context)
	{
		return new XEvalTaskImpl(engine, script, binding, context);
	}
}
