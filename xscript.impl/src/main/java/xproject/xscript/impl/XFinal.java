package xproject.xscript.impl;

import xproject.xlang.XRunnable;

public class XFinal implements XRunnable {

	private XBlock xblock;
	
	protected XFinal(XBlock block)
	{
		xblock = block;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xblock = null;
		finalize();
	}

	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xblock.xfinal();
	}

}
