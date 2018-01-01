package xproject.xlang.impl;

import xproject.xlang.XException;

public class XExceptionImpl implements XException {

	private Exception ex;
	
	protected XExceptionImpl(Exception ex)
	{
		this.ex = ex;
	}
	
	public static XException xnew(Exception ex)
	{
		return new XExceptionImpl(ex);
	}

	public String xgetMessage() throws Exception {
		// TODO Auto-generated method stub
		return ex.getMessage();
	}
}
