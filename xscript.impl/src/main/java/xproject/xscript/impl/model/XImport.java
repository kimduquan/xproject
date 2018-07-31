package xproject.xscript.impl.model;

import xproject.xrmi.XRemote;

public class XImport implements XRemote {

	private XParameters xparameters;
	
	public XImport(XParameters parameters)
	{
		xparameters = parameters;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xparameters = null;
		finalize();
	}

	public void ximport() throws Exception
	{
		xparameters.xclassLoader().xloadClass(xparameters.xclass());
	}
}
