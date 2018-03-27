package xproject.xutil.xconcurrent;

import xproject.xrmi.XRemote;

public interface XRunnable extends XRemote {

	void xrun() throws Exception;
}
