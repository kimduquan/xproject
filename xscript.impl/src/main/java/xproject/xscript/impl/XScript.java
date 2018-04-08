package xproject.xscript.impl;

import xproject.xrmi.XRemote;

public interface XScript extends XRemote {

	boolean xhasNextLine() throws Exception;
	XLine xnextLine() throws Exception;
}
