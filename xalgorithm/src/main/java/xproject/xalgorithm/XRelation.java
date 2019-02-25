package xproject.xalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
		boolean stop = false;
		while(stop == false) {
			stop = true;
			HashSet<XFunctionalDependency> removeFDSet = new HashSet<XFunctionalDependency>();
			for(XFunctionalDependency fd : tempFDSet) {
				//System.out.println("FD : " + fd.xleft().keySet().toString() + "->" + fd.xright().keySet().toString());
				//System.out.println("Closure : " + xclosure.keySet().toString());
				if(xclosure.keySet().containsAll(fd.xleft().keySet())){
					xclosure.putAll(fd.xright());
					removeFDSet.add(fd);
					stop = false;
					if(fds != null) {
						fds.add(fd);
					}
				}
			}
			tempFDSet.removeAll(removeFDSet);
			removeFDSet.clear();
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
			ArrayList<XFunctionalDependency> fds = new ArrayList<XFunctionalDependency>();
			xcalculateClosure(xFDSet, sourceAttrSet, fds);
			if(result != null) {
				resultFDs.add(fds);
			}
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
			if(resultFDs != null) {
				for(List<XFunctionalDependency> t : tempFDs) {
					if(t != null) {
						resultFDs.add(t);
					}
				}
			}
		}
		
		return result;
	}
	
	public Set<XFunctionalDependency> xfindMinimalCover() throws Exception
	{
		HashSet<XFunctionalDependency> result = new HashSet<XFunctionalDependency>();
		for(XFunctionalDependency xfd : xFDSet)
		{
			result.addAll(xfd.decomposeRightAttributes());
		}
		boolean stop = false;
		while(stop == false) {
			stop = true;
			for(XFunctionalDependency xfd : result) {
				HashMap<String, XAttribute> removeAttrSet = new HashMap<String, XAttribute>();
				for(XAttribute xattr : xfd.xleft().values()) {
					HashMap<String, XAttribute> leftAttrSet = new HashMap<String, XAttribute>(xfd.xleft());
					leftAttrSet.remove(xattr.xname());
					if(leftAttrSet.isEmpty() == false) {
						Map<String, XAttribute> closure = xcalculateClosure(result, leftAttrSet, null);
						
						if(closure.containsKey(xattr.xname())) {
							System.out.println("Remove '" + xattr.xname() + "' in " + xfd.xleft().keySet().toString() + "->" + xfd.xright().keySet().toString() + " because " + closure.keySet().toString() + " contains " + xattr.xname());
							removeAttrSet.put(xattr.xname(), xattr);
							stop = false;
						}
					}
				}
				for(String key : removeAttrSet.keySet()) {
					xfd.xleft().remove(key);
				}
				removeAttrSet.clear();
			}
		}
		
		stop = false;
		while(stop == false) {
			stop = true;
			HashSet<XFunctionalDependency> removeFDSet = new HashSet<XFunctionalDependency>();
			for(XFunctionalDependency xfd : result)
			{
				HashSet<XFunctionalDependency> tempFDSet = new HashSet<XFunctionalDependency>(result);
				tempFDSet.remove(xfd);
				if(tempFDSet.isEmpty() == false) {
					Map<String, XAttribute> closure = xcalculateClosure(tempFDSet, xfd.xleft(), null);
					if(closure.keySet().containsAll(xfd.xright().keySet())) {
						System.out.println("Remove " + xfd.xleft().keySet().toString() + " because of (" + xfd.xleft().keySet().toString() + "+ = " + closure.keySet().toString() + "contains " + xfd.xright().keySet().toString());
						removeFDSet.add(xfd);
						stop = false;
					}
				}
			}
			result.removeAll(removeFDSet);
			removeFDSet.clear();
		}
		
		return result;
	}
	
	protected static boolean xequals(Map<String, XAttribute> set1, Map<String, XAttribute> set2)
	{
		return set1.keySet().containsAll(set2.keySet()) && set2.keySet().containsAll(set1.keySet());
	}
	
	protected static boolean xequals(XFunctionalDependency fd1, XFunctionalDependency fd2) throws Exception {
		return xequals(fd1.xleft(), fd2.xleft()) && xequals(fd1.xright(), fd2.xright());
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
	
	public List<XRelation> xnormalize2NF() throws Exception {
		ArrayList<XRelation> result = new ArrayList<XRelation>();
		return result;
	}
	
	protected boolean xis1NF() throws Exception {
		boolean result = true;
		for(XAttribute xattr : xattributeSet.values()) {
			if(xattr.xisPrimitive() == false || xattr.xisMultiValues()) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	protected boolean xis2NF() throws Exception {
		boolean result = xis2NF();
		if(result == true) {
			result = true;
			List<Map<String, XAttribute>> keyAttrSet = xfindAllKeys(null);
			Map<String, XAttribute> nonKeyAttrSet = new HashMap<String, XAttribute>(xattributeSet);
			for(Map<String, XAttribute> keyAttr : keyAttrSet) {
				for(Entry<String, XAttribute> attr : keyAttr.entrySet()) {
					nonKeyAttrSet.remove(attr.getKey());
				}
			}
		}
		return result;
	}
}
