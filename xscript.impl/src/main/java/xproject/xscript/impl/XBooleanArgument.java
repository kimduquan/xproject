package xproject.xscript.impl;

import xproject.xrmi.XRemote;

public class XBooleanArgument implements XRemote, AutoCloseable {
	
	private XArguments xarguments;
	
	public XBooleanArgument(XArguments args)
	{
		xarguments = args;
	}

	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xarguments = null;
		finalize();
	}

	public boolean xboolean(boolean b) throws Exception
	{
		return b;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
