package xproject.xdriver;

import xproject.xrmi.XRemote;

public interface XErrorHandler extends XRemote {

	boolean xisIncludeServerErrors() throws Exception;
	XResponse xthrowIfResponseFailed(XResponse response, long duration) throws Exception;
}
