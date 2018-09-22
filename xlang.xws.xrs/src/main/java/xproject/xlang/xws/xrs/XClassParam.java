package xproject.xlang.xws.xrs;

import java.util.HashMap;

import xproject.xlang.XClass;
import xproject.xrmi.XRemote;

public class XClassParam implements XRemote {

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub

	}
	
	private XClassParam(XClass cls)
	{
		xclass = cls;
	}
	
	public XClass xclass()
	{
		return xclass;
	}
	
	private XClass xclass;
	private static HashMap<String, XClass> xclasses = new HashMap<String, XClass>();
	
	public static XClassParam valueOf(String name)
	{
		return new XClassParam(xclasses.getOrDefault(name, null));
	}

}
