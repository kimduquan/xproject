package xproject.xscript.impl;

import xproject.xlang.XObject;

public abstract class XFunctionBlockImpl extends XFunctionImpl {

	private boolean xfinal;
	private boolean xreturn;
	private XObject xobject;
	private XIteratorImpl xiterator;
	
	protected XFunctionBlockImpl(XFunctionFactory factory, XFunctionImpl parent, XArguments arguments) {
		super(factory, parent, arguments);
		// TODO Auto-generated constructor stub
		xfinal = false;
		xreturn = false;
		xobject = null;
		xiterator = null;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xobject = null;
		xiterator = null;
		super.xfinalize();
	}

	public void xfinal() throws Exception
	{
		xfinal = true;
	}
	
	protected XArguments xgoto(String func) throws Exception
	{
		XArguments found = null;
		while(!xfinal)
		{
			if(xiterator.xhasNext())
			{
				try(XArguments args = xiterator.xnext())
				{
					try(XFunctionImpl xfunc = xnew(args))
					{
						if(args.xfunction().equals(func))
						{
							found = args.xclone();
							break;
						}
						found = xfunc.xgoto(func);
					}
				}
			}
		}
		return found;
	}
	
	protected XObject xeval(XObject t, String end) throws Exception {
		// TODO Auto-generated method stub
		while(!xfinal && !xreturn)
		{
			if(xiterator.xhasNext())
			{
				try(XArguments args = xiterator.xnext())
				{
					try(XFunctionImpl func = xnew(args))
					{
						func.xapply(t);
					}
					if(end.equals(args.xfunction()))
					{
						break;
					}
				}
			}
		}
		return xobject;
	}
	
	public void xreturn(XObject res) throws Exception
	{
		xreturn = true;
		xobject= res;
		
	}
}
