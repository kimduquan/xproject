package xproject.xalgorithm;

import xproject.xrmi.XRemote;

public class XAttribute implements XRemote {

	private String xname;
	
	public XAttribute(String name)
	{
		xname = name;
	}
	
	public String xname() throws Exception
	{
		return xname;
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xname = null;
		finalize();
	}
}
