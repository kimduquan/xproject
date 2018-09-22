package xproject.xscript.impl.xrpc.model;

import xproject.xrmi.XRemote;

public interface XClient extends XRemote {

	XResponse[] xsend(XRequest[] xrequests) throws Exception;
}
