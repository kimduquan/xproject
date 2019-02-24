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
	private Map<String, XAttribute> xleftSideAttrSet;
	private Map<String, XAttribute> xrightSideAttrSet;
	
	public XRelation()
	{
		xattributeSet = new HashMap<String, XAttribute>();
		xFDSet = new HashSet<XFunctionalDependency>();
		xleftSideAttrSet = new HashMap<String, XAttribute>();
		xrightSideAttrSet = new HashMap<String, XAttribute>();
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
			XAttribute xattr = null;
			for(String attr : fd) {
				if(attr.equals("->")) {
					isLeft = false;
				}
				else if(isLeft) {
						xattr = new XAttribute(attr);
						xleft.put(attr, xattr);
						xleftSideAttrSet.put(attr, xattr);
					}
				else {
					xattr = new XAttribute(attr);
					xright.put(attr, xattr);
					xrightSideAttrSet.put(attr, xattr);
				}
			}
			xFDSet.add(new XFunctionalDependency(xleft, xright));
		}
	}
	
	
	protected static Map<String, XAttribute> xcalculateClosure(Set<XFunctionalDependency> xfdSet, Map<String, XAttribute> xattrSet, List<XFunctionalDependency> fds) throws Exception
	{
		HashMap<String, XAttribute> xclosure = new HashMap<String, XAttribute>(xattrSet);
		HashSet<XFunctionalDependency> tempFDSet = new HashSet<XFunctionalDependency>(xfdSet);
		for(XFunctionalDependency fd : tempFDSet) {
			if(xclosure.keySet().containsAll(fd.xleft().keySet())){
				xclosure.putAll(fd.xright());
				if(fds != null) {
					fds.add(fd);
				}
			}
		}
		return xclosure;
	}
	
	public Map<String, XAttribute> xcalculateClosure(String... attrSet ) throws Exception
	{
		Map<String, XAttribute> xattrSet = new HashMap<String, XAttribute>();
		XAttribute temp = null;
		for(String attr : attrSet) {
			temp = xattributeSet.get(attr);
			xattrSet.put(temp.xname(), temp);
		}
		return xcalculateClosure(xFDSet, xattrSet, null);
	}
	
	public Map<String, XAttribute> xfindAnyKey() throws Exception {
		Map<String, XAttribute> result = new HashMap<String, XAttribute>(xattributeSet);
		
		for(XAttribute xattr : xattributeSet.values()) {
			Map<String, XAttribute> temp = new HashMap<String, XAttribute>(result);
			temp.remove(xattr.xname());
			Map<String, XAttribute> tempClosure = xcalculateClosure(xFDSet, temp, null);
			if(xequals(tempClosure, xattributeSet)) {
				result.remove(xattr.xname());
			}
		}
		
		return result;
	}
	
	protected  static Map<String, XAttribute> xsubtract(Map<String, XAttribute> set1, Map<String, XAttribute> set2) {
		Map<String, XAttribute> result = new HashMap<String, XAttribute>(set1);
		
		for(String key : set1.keySet()) {
			if(set2.containsKey(key)) {
				result.remove(key);
			}
		}
		
		return result;
	}
	
	protected  static Map<String, XAttribute> xintersect(Map<String, XAttribute> set1, Map<String, XAttribute> set2) {
		Map<String, XAttribute> result = new HashMap<String, XAttribute>();
		for(String key : set1.keySet()) {
			if(set2.containsKey(key)) {
				result.put(key, set2.get(key));
			}
		}
		return result;
	}
	
	protected static Map<String, XAttribute> xunion(Map<String, XAttribute> set1, Map<String, XAttribute> set2){
		Map<String, XAttribute> result = new HashMap<String, XAttribute>(set1);
		result.putAll(set2);
		return result;
	}
	
	protected static List<Map<String, XAttribute>> xfindAllChildrenSet(Map<String, XAttribute> set) throws Exception {
		ArrayList<Map<String, XAttribute>> result = new ArrayList<Map<String, XAttribute>>();
		
		result.add(new HashMap<String, XAttribute>());
		ArrayList<Map<String, XAttribute>> cache = new ArrayList<Map<String, XAttribute>>(result);
		
		for(int i = 0; i < set.size(); i++) {
			ArrayList<Map<String, XAttribute>> temp = new ArrayList<Map<String, XAttribute>>(cache);
			cache.clear();
			Set<String> remain = new HashSet<String>(set.keySet());
			for(Map<String, XAttribute> prevSet : temp) {
				if(remain.isEmpty()) {
					break;
				}
				remain.removeAll(prevSet.keySet());
				for(String key : remain) {
					XAttribute xattr = set.get(key);
					Map<String, XAttribute> childSet = new HashMap<String, XAttribute>(prevSet);
					childSet.put(xattr.xname(), xattr);
					result.add(childSet);
					cache.add(childSet);
				}
			}
			temp.clear();
		}
		return result;
	}
	
	public List<Map<String, XAttribute>> xfindAllKeys( List<List<XFunctionalDependency>> resultFDs ) throws Exception {
		ArrayList<Map<String, XAttribute>> result = new ArrayList<Map<String, XAttribute>>();
		
		
		Map<String, XAttribute> sourceAttrSet = xsubtract(xattributeSet, xrightSideAttrSet);
		Map<String, XAttribute> middleAttrSet = xintersect(xleftSideAttrSet, xrightSideAttrSet);
		
		if(middleAttrSet.isEmpty()) {
			result.add(sourceAttrSet);
		}
		else {
			ArrayList<Map<String, XAttribute>> xsuperKeys = new ArrayList<Map<String, XAttribute>>();
			List<List<XFunctionalDependency>> xsuperKeysFDs = new ArrayList<List<XFunctionalDependency>>();
			List<Map<String, XAttribute>> xchildrenSets = xfindAllChildrenSet(middleAttrSet);
			for(Map<String, XAttribute> childSet : xchildrenSets) {
				Map<String, XAttribute> temp = xunion(sourceAttrSet, childSet);
				ArrayList<XFunctionalDependency> fds = new ArrayList<XFunctionalDependency>();
				Map<String, XAttribute> tempClosure = xcalculateClosure(xFDSet, temp, fds);
				if(xequals(tempClosure, xattributeSet)) {
					xsuperKeys.add(temp);
					xsuperKeysFDs.add(fds);
				}
			}
			ArrayList<Map<String, XAttribute>> tempResult = new ArrayList<Map<String, XAttribute>>(xsuperKeys);
			ArrayList<List<XFunctionalDependency>> tempFDs = new ArrayList<List<XFunctionalDependency>>(xsuperKeysFDs);
			
			for(int i = 0; i < xsuperKeys.size(); i++) {
				for(int j = 0; j < xsuperKeys.size(); j++) {
					if(i != j) {
						if(xsuperKeys.get(i).keySet().containsAll(xsuperKeys.get(j).keySet())) {
							tempResult.set(i, null);
							tempFDs.set(i, null);
						}
					}
				}
			}
			
			for(Map<String, XAttribute> t : tempResult) {
				if(t != null) {
					result.add(t);
				}
			}
			for(List<XFunctionalDependency> t : tempFDs) {
				if(t != null) {
					resultFDs.add(t);
				}
			}
		}
		
		return result;
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
				
				/*if(xequivalent(result, tempFDSet))
				{
					xfd.xleft().remove(xattr.xname());
				}*/
			}
		}
		
		HashSet<XFunctionalDependency> temp = new HashSet<XFunctionalDependency>(result);
		for(XFunctionalDependency xfd : temp)
		{
			HashSet<XFunctionalDependency> tempFDSet = new HashSet<XFunctionalDependency>(result);
			tempFDSet.remove(xfd);
			
			/*if(xequivalent(tempFDSet, result))
			{
				result.remove(xfd);
			}*/
		}
		return result;
	}
	
	protected static boolean xequals(Map<String, XAttribute> set1, Map<String, XAttribute> set2)
	{
		return set1.keySet().containsAll(set2.keySet()) && set2.keySet().containsAll(set1.keySet());
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		for(XAttribute xattr : xattributeSet.values()) {
			xattr.xfinalize();
		}
		xattributeSet.clear();
		xattributeSet = null;
		for(XFunctionalDependency fd : xFDSet) {
			fd.xfinalize();
		}
		xFDSet.clear();
		xFDSet = null;
	}
}
