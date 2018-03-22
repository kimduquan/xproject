package xproject.xcr.impl;

import javax.jcr.NamespaceRegistry;

import xproject.xcr.XNamespaceRegistry;

public class XNamespaceRegistryImpl extends XCRImpl<XNamespaceRegistry, NamespaceRegistry>
		implements XNamespaceRegistry {

	protected XNamespaceRegistryImpl(NamespaceRegistry namespaceRegistry) {
		super(namespaceRegistry);
		// TODO Auto-generated constructor stub
	}

	public String xgetPrefix(String uri) throws Exception {
		// TODO Auto-generated method stub
		return x().getPrefix(uri);
	}

	public String[] xgetPrefixes() throws Exception {
		// TODO Auto-generated method stub
		return x().getPrefixes();
	}

	public String xgetURI(String prefix) throws Exception {
		// TODO Auto-generated method stub
		return x().getURI(prefix);
	}

	public String[] xgetURIs() throws Exception {
		// TODO Auto-generated method stub
		return x().getURIs();
	}

	public void xregisterNamespace(String prefix, String uri) throws Exception {
		// TODO Auto-generated method stub
		x().registerNamespace(prefix, uri);
	}

	public void xunregisterNamespace(String prefix) throws Exception {
		// TODO Auto-generated method stub
		x().unregisterNamespace(prefix);
	}

}
