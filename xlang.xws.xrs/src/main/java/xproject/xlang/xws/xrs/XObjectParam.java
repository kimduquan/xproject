package xproject.xlang.xws.xrs;

import java.util.HashMap;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public class XObjectParam implements XRemote {

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub

	}
	
	private XObjectParam(XObject object)
	{
		xobject = object;
	}
	
	private XObject xobject;
	private static HashMap<Integer, XObject> xobjects = new HashMap<Integer, XObject>();

	public static XObjectParam valueOf(String hashCode)
	{
		if(hashCode.equals("null"))
		{
			return new XObjectParam(XObject.xnull);
		}
		else
		{
			return new XObjectParam(xobjects.getOrDefault(Integer.valueOf(hashCode), XObject.xnull));
		}
	}
	
	public XObject xobject()
	{
		return xobject;
	}
}
