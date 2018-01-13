package xproject.xscript.impl;

import java.util.HashMap;
import java.util.Set;

import xproject.xlang.XObject;
import xproject.xscript.XBindings;

public class XBindingsImpl implements XBindings {

	private HashMap<String, XObject> bindings;
	
	protected XBindingsImpl()
	{
		bindings = new HashMap<String, XObject>();
	}
	
	public XObject xget(String key) throws Exception {
		// TODO Auto-generated method stub
		return bindings.get(key);
	}

	public XObject xput(String name, XObject object) throws Exception {
		// TODO Auto-generated method stub
		return bindings.put(name, object);
	}

	public boolean xcontainsKey(String key) throws Exception {
		// TODO Auto-generated method stub
		return bindings.containsKey(key);
	}

	public void xremove(String key) throws Exception {
		// TODO Auto-generated method stub
		bindings.remove(key);
	}

	public static XBindings xnew()
	{
		return new XBindingsImpl();
	}

	public Set<String> xkeySet() throws Exception {
		// TODO Auto-generated method stub
		return bindings.keySet();
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		bindings.clear();
		bindings = null;
		finalize();
	}
}
