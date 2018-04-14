package xproject.xunit.xrunner.xnotification;

import xproject.xlang.XException;
import xproject.xrmi.XRemote;
import xproject.xunit.xrunner.XDescription;

public interface XFailure extends XRemote {
	XDescription xgetDescription() throws Exception;
	XException xgetException() throws Exception;
	String xgetMessage() throws Exception;
	String xgetTestHeader() throws Exception;
	String xgetTrace() throws Exception;
}
