package xproject.xcr;

import xproject.xrmi.XRemote;

public interface XNamespaceRegistry extends XRemote {
	String xgetPrefix(String uri) throws Exception;
	String[] xgetPrefixes() throws Exception;
	String xgetURI(String prefix) throws Exception;
	String[] xgetURIs() throws Exception;
	void xregisterNamespace(String prefix, String uri) throws Exception;
	void xunregisterNamespace(String prefix) throws Exception;
}
