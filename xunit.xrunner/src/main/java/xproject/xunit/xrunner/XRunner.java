package xproject.xunit.xrunner;

import xproject.xrmi.XRemote;

public interface XRunner extends XRemote {

	void xrun(XRunNotifier notifier) throws Exception;
}
