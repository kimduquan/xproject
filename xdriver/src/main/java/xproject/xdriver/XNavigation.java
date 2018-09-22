package xproject.xdriver;

import xproject.xrmi.XRemote;

public interface XNavigation extends XRemote {

	void xback() throws Exception;
	void xforward() throws Exception;
	void xrefresh() throws Exception;
	void xto(String url) throws Exception;
}
