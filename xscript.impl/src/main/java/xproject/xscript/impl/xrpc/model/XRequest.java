package xproject.xscript.impl.xrpc.model;

import xproject.xrmi.XRemote;

public interface XRequest extends XRemote {

	String xrpc() throws Exception;
	String xmethod() throws Exception;
	XStructure xparams() throws Exception;
	XIdentifier xid() throws Exception;
}
