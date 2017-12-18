package xproject.xrmi.xregistry;

import xproject.xrmi.XRemote;

public interface XRegistry extends XRemote {

	void xbind(String name, XRemote remote) throws Exception;
	void xrebind(String name, XRemote remote) throws Exception;
	String[] xlist() throws Exception;
	XRemote xlookup(String name) throws Exception;
	void xunbind(String name) throws Exception;
}
