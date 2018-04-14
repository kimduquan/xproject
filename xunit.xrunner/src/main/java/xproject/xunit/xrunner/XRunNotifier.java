package xproject.xunit.xrunner;

import xproject.xrmi.XRemote;
import xproject.xunit.xrunner.xnotification.XFailure;

public interface XRunNotifier extends XRemote {
	void xfireTestAssumptionFailed(XFailure failure) throws Exception;
	void xfireTestFailure(XFailure failure) throws Exception;
	void xfireTestFinished(XDescription description) throws Exception;
	void xfireTestIgnored(XDescription description) throws Exception;
	void xfireTestStarted(XDescription description) throws Exception;
	void xpleaseStop() throws Exception;
}
