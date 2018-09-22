package xproject.xdriver;

import xproject.xrmi.XRemote;

public interface XBy extends XRemote {

	XBy xclass(String cls) throws Exception;
	XBy xselector(String selector) throws Exception;
	XBy xid(String id) throws Exception;
	XBy xtext(String text) throws Exception;
	XBy xname(String name) throws Exception;
	XBy xpartialText(String partialText) throws Exception;
	XBy xtag(String tag) throws Exception;
	XBy xpath(String path) throws Exception;
}
