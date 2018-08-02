package xproject.xlang;

import xproject.xrmi.XRemote;

public interface XAutoCloseable extends XRemote {

	void xclose() throws Exception;
}
