package xproject.xscript.impl;

import xproject.xlang.XClass;
import xproject.xlang.XRunnable;

public class XImport implements XRunnable {

	private XLine xline;
	private XContext xcontext;
	
	protected XImport(XLine line, XContext context)
	{
		xline = line;
		xcontext = context;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xline = null;
		xcontext = null;
		finalize();
	}

	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		if(xline.xhasNextParam(XConstants.CLASS))
		{
			String name = (String) xline.xnextParam();
			if(name != null)
			{
				XClass xclass = xcontext.xclassLoader().xloadClass(name);
				if(xclass != null)
				{
					xcontext.ximport(xclass.xgetSimpleName(), xclass);
				}
			}
		}
	}
}
