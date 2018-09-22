package xproject.xaccessibility;

import xproject.xrmi.XRemote;

public interface XAccessible extends XRemote {
	XAccessibleContext xgetAccessibleContext() throws Exception;
}
