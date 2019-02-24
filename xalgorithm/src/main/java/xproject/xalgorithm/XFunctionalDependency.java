package xproject.xalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xproject.xrmi.XRemote;

public class XFunctionalDependency implements XRemote {

	private Map<String, XAttribute> xleft;
	private Map<String, XAttribute> xright;
	
	public XFunctionalDependency(Map<String, XAttribute> left, Map<String, XAttribute> right)
	{
		xleft = new HashMap<String, XAttribute>(left);
		xright = new HashMap<String, XAttribute>(right);
	}
	
	public Map<String, XAttribute> xleft() throws Exception
	{
		return xleft;
	}
	
	public Map<String, XAttribute> xright() throws Exception
	{
		return xright;
	}
	
	public List<XFunctionalDependency> decomposeRightAttributes() throws Exception
	{
		ArrayList<XFunctionalDependency> result = new ArrayList<XFunctionalDependency>();
		for(XAttribute xattr : xright.values())
		{
			HashMap<String, XAttribute> right = new HashMap<String, XAttribute>();
			right.put(xattr.xname(), xattr);
			result.add(new XFunctionalDependency(xleft, right));
		}
		return result;
	}
	
	public XFunctionalDependency xclone()
	{
		return new XFunctionalDependency(xleft, xright);
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xleft.clear();
		xleft = null;
		xright.clear();
		xright = null;
	}
}
