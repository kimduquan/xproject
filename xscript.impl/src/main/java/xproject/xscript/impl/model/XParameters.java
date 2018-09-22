package xproject.xscript.impl.model;

import java.util.Iterator;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XParameters extends XRemote, AutoCloseable {

	String xclass() throws Exception;
	String xthis() throws Exception;
	String xreturn() throws Exception;
	String xmethod() throws Exception;
	
	Iterator<XClass> xtypes() throws Exception;
	Iterator<String> xnames() throws Exception;
	Iterator<String> xvalues() throws Exception;
	Iterator<XObject> xparams() throws Exception;
}
