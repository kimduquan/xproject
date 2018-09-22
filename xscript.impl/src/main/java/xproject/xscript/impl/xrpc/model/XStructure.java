package xproject.xscript.impl.xrpc.model;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XStructure extends XRemote {

	String[] names() throws Exception;
	String[] values() throws Exception;
	XObject xparams() throws Exception;
}
