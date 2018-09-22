package xproject.xarchitecture;

import xproject.xrmi.XRemote;

public interface XAgent extends XRemote {

	String xgetName() throws Exception;
	void xstart() throws Exception;
	void xstop() throws Exception;
}
