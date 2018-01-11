package xproject.xlang.impl;

import xproject.xlang.XException;
import xproject.xlang.XFactory;

public class XExceptionImpl extends XObjectImpl implements XException {

	private Exception ex;
	
	protected XExceptionImpl(Exception ex, XFactory factory)
	{
		super(ex, factory);
		this.ex = ex;
	}
	
	public static XException xnew(Exception ex, XFactory factory)
	{
		return new XExceptionImpl(ex, factory);
	}

	public String xgetMessage() throws Exception {
		// TODO Auto-generated method stub
		return ex.getMessage();
	}

	public void xthrow() throws Exception {
		// TODO Auto-generated method stub
		throw ex;
	}
}
