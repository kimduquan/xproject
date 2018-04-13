package xproject.xscript.impl;

import java.util.HashMap;

import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xscript.XBindings;

public class XBindingImpl implements XBinding 
{
	private XBindings xbindings;
	private HashMap<String, XClass> xclasses;
	private XFactory xfactory;
	
	protected XBindingImpl(XBindings bindings, XFactory factory)
	{
		xbindings = bindings;
		xclasses = new HashMap<String, XClass>();
		xfactory = factory;
	}
	
	public void xfinalize() throws Throwable 
	{
		xclasses.clear();
		xclasses = null;
		xbindings = null;
		finalize();
	}

	public XBindings xbindings() throws Exception 
	{
		return xbindings;
	}

	public void ximport(String key, XClass xclass) throws Exception 
	{
		xclasses.put(key, xclass);
	}

	public XClass xgetClass(String key) throws Exception {
		// TODO Auto-generated method stub
		return xclasses.get(key);
	}

	public XClass[] xgetClasses() throws Exception 
	{
		XClass[] arr = new XClass[xclasses.values().size()];
		arr = xclasses.values().toArray(arr);
		return arr;
	}

	public boolean xhasClass(String key) throws Exception {
		// TODO Auto-generated method stub
		return xclasses.containsKey(key);
	}

	public XFactory xfactory() throws Exception {
		// TODO Auto-generated method stub
		return xfactory;
	}
	
	public static XBinding xnew(XBindings bindings, XFactory factory)
	{
		return new XBindingImpl(bindings, factory);
	}
}
