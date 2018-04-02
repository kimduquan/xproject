package xproject.xutil.xconcurrent;

import xproject.xlang.XRunnable;
import xproject.xrmi.XRemote;

public interface XExecutor extends XRemote {

	void xexecute(XRunnable command) throws Exception;
}
