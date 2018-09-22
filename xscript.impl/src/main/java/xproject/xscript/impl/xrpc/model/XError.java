package xproject.xscript.impl.xrpc.model;

import xproject.xrmi.XRemote;

public interface XError extends XRemote {

	int xcode() throws Exception;
	String xmessage() throws Exception;
	XStructure xdata() throws Exception;
}
