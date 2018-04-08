package xproject.xscript.impl;

import xproject.xlang.XObject;
import xproject.xlang.XRunnable;
import xproject.xscript.XBindings;

public class XEvalImpl extends XBlockImpl implements XEval {

	private XBindings xbindings;
	private XContext xcontext;
	
	protected XEvalImpl(XScript script, XBindings bindings, XContext context)
	{
		super(script);
		xbindings = bindings;
		xcontext = context;
	}
	
	public void xfinalize() throws Throwable 
	{
		// TODO Auto-generated method stub
		xbindings = null;
		xcontext = null;
		super.xfinalize();
	}

	protected void xrun(String method, XLine line, XScript script) throws Exception {
		// TODO Auto-generated method stub
		XRunnable run = null;
		if(method.equals(XConstants.FINAL))
		{
			run = new XFinal(this);
		}
		else if(method.equals(XConstants.RETURN))
		{
			run = new XReturn(this, line, xbindings);
		}
		else if(method.equals(XConstants.IMPORT))
		{
			run = new XImport(line, xcontext);
		}
		else if(method.equals(XConstants.NEW))
		{
			run = new XNew(line, xcontext, xbindings);
		}
		if(run != null)
		{
			run.xrun();
			try 
			{
				run.xfinalize();
			} catch (Throwable e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void xreturn(XObject object) throws Exception 
	{
		
	}
}
