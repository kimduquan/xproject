package xproject.xarchitecture;

import xproject.xrmi.XRemote;

public interface XContainer extends XRemote {

	void xmain(String[] args) throws Exception;
	XContainer xcontainer(String name) throws Exception;
	XAgent xagent(String name) throws Exception;
}
