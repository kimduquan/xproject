package xproject.xunit.xrunner.impl;

import xproject.xlang.XException;
import xproject.xunit.xrunner.XDescription;
import xproject.xunit.xrunner.xnotification.XFailure;

public class XFailureImpl implements XFailure {

	private XDescription xdescription;
	private XException xexception;
	private String message;
	private String testHeader;
	private String trace;
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		finalize();
	}

	public XDescription xgetDescription() throws Exception {
		// TODO Auto-generated method stub
		return xdescription;
	}

	public XException xgetException() throws Exception {
		// TODO Auto-generated method stub
		return xexception;
	}

	public String xgetMessage() throws Exception {
		// TODO Auto-generated method stub
		return message;
	}

	public String xgetTestHeader() throws Exception {
		// TODO Auto-generated method stub
		return testHeader;
	}

	public String xgetTrace() throws Exception {
		// TODO Auto-generated method stub
		return trace;
	}

}
