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
	
	public boolean xisPrimitive() throws Exception {
		return true;
	}
	
	public boolean xhasMultiValues() throws Exception {
		return false;
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xname = null;
		finalize();
	}
}
