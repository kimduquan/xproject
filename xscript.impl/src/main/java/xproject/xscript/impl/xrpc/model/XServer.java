package xproject.xscript.impl.xrpc.model;

import xproject.xrmi.XRemote;

public interface XServer extends XRemote {

	XResponse[] xprocess(XRequest[] requests) throws Exception;
}
