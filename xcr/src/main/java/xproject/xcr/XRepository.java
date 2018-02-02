package xproject.xcr;

import xproject.xrmi.XRemote;

public interface XRepository extends XRemote {
	String xgetDescriptor(String key) throws Exception;
	String[] xgetDescriptorKeys() throws Exception;
	XValue xgetDescriptorValue(String key) throws Exception;
	XValue[] xgetDescriptorValues(String key) throws Exception;
	boolean xisSingleValueDescriptor(String key) throws Exception;
	boolean xisStandardDescriptor(String key) throws Exception;
	XSession xlogin() throws Exception;
	XSession xlogin(XCredentials credentials) throws Exception;
	XSession xlogin(XCredentials credentials, String workspaceName) throws Exception;
	XSession xlogin(String workspaceName) throws Exception;
}
