package xproject.xunit.xrunner;

import xproject.xlang.XException;
import xproject.xrmi.XRemote;
import xproject.xunit.xrunner.xnotification.XFailure;

public interface XRunnerFactory extends XRemote {
	XFailure xFailure(String message, XException exception) throws Exception;
}
