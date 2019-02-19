package xproject.xalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class XRelation {

	private Map<String, XAttribute> xattributeSet;
	private Set<XFunctionalDependency> xFDSet;
	
	public XRelation()
	{
		xattributeSet = new HashMap<String, XAttribute>();
		xFDSet = new HashSet<XFunctionalDependency>();
	}
	
	public void addAttribute(String name)
	{
		xattributeSet.put(name, new XAttribute(name));
	}
	
	public void addFD(String[] left, String[] right)
	{
		HashMap<String, XAttribute> xleft = new HashMap<String, XAttribute>();
		HashMap<String, XAttribute> xright = new HashMap<String, XAttribute>();
		for(String l : left)
		{
			xleft.put(l, new XAttribute(l));
		}
		for(String r : right)
		{
			xleft.put(r, new XAttribute(r));
		}
		XFunctionalDependency fd = new XFunctionalDependency(xleft, xright);
		xFDSet.add(fd);
	}
	
	public static Map<String, XAttribute> xfindClosure(Set<XFunctionalDependency> FDSet, Map<String, XAttribute> F) throws Exception
	{
		HashMap<String, XAttribute> xclosure = new HashMap<String, XAttribute>();
		for(XFunctionalDependency fd : FDSet)
		{
			if(xclosure.keySet().containsAll(fd.xleft().keySet()))
			{
				xclosure.putAll(fd.xright());
			}
		}
		return xclosure;
	}
	
	public static Set<XFunctionalDependency> xfindMinimalCover(Set<XFunctionalDependency> xFDSet) throws Exception
	{
		HashSet<XFunctionalDependency> result = new HashSet<XFunctionalDependency>();
		
		for(XFunctionalDependency xfd : xFDSet)
		{
			result.addAll(xfd.decomposeRightAttributes());
		}
		
		for(XFunctionalDependency xfd : result)
		{
			HashMap<String, XAttribute> xleft = new HashMap<String, XAttribute>(xfd.xleft());
			for(XAttribute xattr : xleft.values())
			{
				HashSet<XFunctionalDependency> tempFDSet = new HashSet<XFunctionalDependency>(result);
				tempFDSet.remove(xfd);
				
				XFunctionalDependency tempFD = xfd.xclone();
				tempFD.xleft().remove(xattr.xname());
				
				tempFDSet.add(tempFD);
				
				if(xequals(result, tempFDSet))
				{
					xfd.xleft().remove(xattr.xname());
				}
			}
		}
		
		HashSet<XFunctionalDependency> temp = new HashSet<XFunctionalDependency>(result);
		for(XFunctionalDependency xfd : temp)
		{
			HashSet<XFunctionalDependency> tempFDSet = new HashSet<XFunctionalDependency>(result);
			tempFDSet.remove(xfd);
			
			if(xequals(tempFDSet, result))
			{
				result.remove(xfd);
			}
		}
		return result;
	}
	
	public Map<String, XAttribute> xfindAllKeys() throws Exception
	{
		HashMap<String, XAttribute> K = new HashMap<String, XAttribute>(xattributeSet);
		
		for(XAttribute xattr : xattributeSet.values())
		{
			HashMap<String, XAttribute> temp = new HashMap<String, XAttribute>(xattributeSet);
			temp.remove(xattr.xname());
			
			Map<String, XAttribute> xclosure = xfindClosure(xFDSet, temp);
			
			if(xequals(xclosure, xattributeSet))
			{
				K.remove(xattr.xname());
			}
		}
		return K;
	}
	
	public static boolean xequals(Map<String, XAttribute> set1, Map<String, XAttribute> set2)
	{
		return set1.keySet().containsAll(set2.keySet());
	}
	
	public static boolean xequals(Set<XFunctionalDependency> xFDSet1, Set<XFunctionalDependency> xFDSet2) throws Exception
	{
		for(XFunctionalDependency xfd : xFDSet2)
		{
			Map<String, XAttribute> xclosure = xfindClosure(xFDSet1, xfd.xleft());
			
			if(xclosure.keySet().containsAll(xfd.xright().keySet()) == false)
			{
				return false;
			}
		}
		
		for(XFunctionalDependency xfd : xFDSet1)
		{
			Map<String, XAttribute> xclosure = xfindClosure(xFDSet2, xfd.xleft());
			
			if(xclosure.keySet().containsAll(xfd.xright().keySet()) == false)
			{
				return false;
			}
		}
		
		return true;
	}
}
