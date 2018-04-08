package xproject.xscript.impl;

import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xscript.XBindings;
import xproject.xutil.XScanner;

public interface XLine extends XRemote 
{
	XScanner xscanner() throws Exception;
	long xlineNumber() throws Exception;
	void xclose() throws Exception;
	XLine xclone() throws Exception;
	
	String xmethod() throws Exception;
	boolean xhasNextParam(String name) throws Exception;
	Object xnextParam() throws Exception;
	XObject xnextObjectParam(XBindings bindings) throws Exception;
	XClass xnextClassParam(XContext context) throws Exception;
	XObject[] xparameter(XBindings bindings, XFactory factory) throws Exception;
}
