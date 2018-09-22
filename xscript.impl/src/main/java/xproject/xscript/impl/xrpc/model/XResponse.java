package xproject.xscript.impl.xrpc.model;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XResponse extends XRemote {

	String xrpc() throws Exception;
	XObject xresult() throws Exception;
	XError xerror() throws Exception;
	XIdentifier xid() throws Exception;
}
