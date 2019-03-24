package xproject.xscript.impl;

import xproject.xutil.xfunction.XFunction;

public abstract class XFunctionImpl implements XFunction, AutoCloseable {
	
	private XFunctionImpl xparent;
	private XArguments xarguments;
	private XFunctionFactory xfactory;
	
	protected XFunctionImpl(XFunctionFactory factory, XFunctionImpl parent, XArguments arguments)
	{
		xparent = parent;
		xarguments = arguments;
		xfactory = factory;
	}

	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xparent = null;
		xarguments = null;
		xfactory = null;
		finalize();
	}
	
	public XFunction xparent() throws Exception
	{
		return xparent;
	}
	
	public XArguments xarguments() throws Exception
	{
		return xarguments;
	}
	
	protected XFunctionImpl xnew(XArguments args) throws Exception
	{
		XFunctionImpl newFunc = null;
		XFunctionImpl func = this;
		XFunctionFactory factory = null;
		while(func != null && newFunc == null)
		{
			factory = func.xfactory;
			if(factory != null)
			{
				newFunc = factory.xnew(args, this);
			}
		}
		return newFunc;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		try {
			xfinalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected XArguments xgoto(String end) throws Exception
	{
		return null;
	}
}
