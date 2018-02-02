package xproject.xutil;

import xproject.xrmi.XRemote;

public interface XIterator<T extends XRemote> extends XRemote {

	boolean xhasNext() throws Exception;
	T xnext() throws Exception;
	void xremove() throws Exception;
}
