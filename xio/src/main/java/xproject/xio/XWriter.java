package xproject.xio;

import xproject.xrmi.XRemote;

public interface XWriter extends XRemote {

	void xwrite(String str) throws Exception;
	void xflush() throws Exception;
	void xclose() throws Exception;
}
