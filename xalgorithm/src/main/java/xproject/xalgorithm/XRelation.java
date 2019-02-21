package xproject.xalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xproject.xrmi.XRemote;

public class XRelation implements XRemote {

	private Map<String, XAttribute> xattributeSet;
	private Set<XFunctionalDependency> xFDSet;
	
	public XRelation()
	{
		xattributeSet = new HashMap<String, XAttribute>();
		xFDSet = new HashSet<XFunctionalDependency>();
	}
	
	public void xaddAttributes(String... attributes) throws Exception {
		for(String attr : attributes) {
			xattributeSet.put(attr, new XAttribute(attr));
		}
	}
	
	public void xaddFunctionalDependencies(String[]... data) throws Exception {
		for(String[] fd : data) {
			boolean isLeft = true;
			HashMap<String, XAttribute> xleft = new HashMap<String, XAttribute>();
			HashMap<String, XAttribute> xright = new HashMap<String, XAttribute>();
			for(String attr : fd) {
				if(attr.equals("->")) {
					isLeft = false;
				}
				else if(isLeft) {
						xleft.put(attr, new XAttribute(attr));
					}
				else {
					xright.put(attr, new XAttribute(attr));
				}
			}
			xFDSet.add(new XFunctionalDependency(xleft, xright));
		}
	}
	
	public static Map<String, XAttribute> xfindClosure(Set<XFunctionalDependency> FDSet, Map<String, XAttribute> F) throws Exception
	{
		HashMap<String, XAttribute> xclosure = new HashMap<String, XAttribute>(F);
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
				
				if(xequivalent(result, tempFDSet))
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
			
			if(xequivalent(tempFDSet, result))
			{
				result.remove(xfd);
			}
		}
		return result;
	}
	
	public List<Map<String, XAttribute>> xfindAllKeys(List<List<XFunctionalDependency>> resultFDSets) throws Exception
	{
		ArrayList<Map<String, XAttribute>> result = new ArrayList<Map<String, XAttribute>>();
		
		ArrayList<Set<XFunctionalDependency>> remainFDSets = new ArrayList<Set<XFunctionalDependency>>();
		ArrayList<Map<String, XAttribute>> resultAttrSets = new ArrayList<Map<String, XAttribute>>();
		ArrayList<Map<String, XAttribute>> remainAttrSets = new ArrayList<Map<String, XAttribute>>();
		
		for(XAttribute xattr : xattributeSet.values())
		{
			Map<String, XAttribute> resultAttrSet = new HashMap<String, XAttribute>();
			Map<String, XAttribute> remainAttrSet = new HashMap<String, XAttribute>(xattributeSet);
			resultAttrSet.put(xattr.xname(), xattr);
			remainAttrSet.remove(xattr.xname());
			resultAttrSets.add(resultAttrSet);
			remainAttrSets.add(remainAttrSet);
			
			resultFDSets.add(new ArrayList<XFunctionalDependency>());
			remainFDSets.add(new HashSet<XFunctionalDependency>(xFDSet));
		}
		
		Iterator<List<XFunctionalDependency>> itResultFDSet = resultFDSets.iterator();
		Iterator<Map<String, XAttribute>> itResultAttrSet = resultAttrSets.iterator();
		Iterator<Set<XFunctionalDependency>> itRemainFDSet = remainFDSets.iterator();
		Iterator<Map<String, XAttribute>> itRemainAttrSet = remainAttrSets.iterator();
		
		while(itResultFDSet.hasNext() 
				&& itResultAttrSet.hasNext() 
				&& itRemainFDSet.hasNext() 
				&& itRemainAttrSet.hasNext()) {
			
			Map<String, XAttribute> resultAttrSet = itResultAttrSet.next();
			List<XFunctionalDependency> resultFDSet = itResultFDSet.next();
			Map<String, XAttribute> remainAttrSet = itRemainAttrSet.next();
			Set<XFunctionalDependency> remainFDSet = itRemainFDSet.next();
			
			Set<XFunctionalDependency> tempRemainFDSet = new HashSet<XFunctionalDependency>(remainFDSet);
			Map<String, XAttribute> tempResultAttrSet = new HashMap<String, XAttribute>(resultAttrSet);
			Map<String, XAttribute> tempRemainAttrSet = new HashMap<String, XAttribute>(remainAttrSet);
			
			for(XFunctionalDependency fd : remainFDSet) {
				if(tempResultAttrSet.keySet().containsAll(fd.xleft().keySet())) {
					resultFDSet.add(fd);
					tempRemainFDSet.remove(fd);
					tempResultAttrSet.putAll(fd.xright());
				}
			}
			
			if(tempResultAttrSet.keySet().containsAll(xattributeSet.keySet())
					&& xattributeSet.keySet().containsAll(tempResultAttrSet.keySet())) {
				result.add(resultAttrSet);
			}
			else {
				
			}
		}
		
		return result;
	}
	
	public static boolean xequals(Map<String, XAttribute> set1, Map<String, XAttribute> set2)
	{
		return set1.keySet().containsAll(set2.keySet()) && set2.keySet().containsAll(set1.keySet());
	}
	
	public static boolean xequivalent(Set<XFunctionalDependency> xFDSet1, Set<XFunctionalDependency> xFDSet2) throws Exception
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

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		for(XAttribute xattr : xattributeSet.values()) {
			xattr.xfinalize();
		}
		xattributeSet.clear();
	}
}
