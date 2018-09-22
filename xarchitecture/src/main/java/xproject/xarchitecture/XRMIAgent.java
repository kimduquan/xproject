package xproject.xarchitecture;

import xproject.xrmi.xregistry.XRegistry;

public interface XRMIAgent extends XAgent {

	XRegistry xregistry() throws Exception;
	static final String Name = "xrmi";
}
