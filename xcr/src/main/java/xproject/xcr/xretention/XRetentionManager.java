package xproject.xcr.xretention;

import xproject.xrmi.XRemote;

public interface XRetentionManager extends XRemote {
	XHold xaddHold(String absPath, String name, boolean isDeep) throws Exception;
	XHold[] xgetHolds(String absPath) throws Exception;
	XRetentionPolicy xgetRetentionPolicy(String absPath) throws Exception;
	void xremoveHold(String absPath, XHold hold) throws Exception;
	void xremoveRetentionPolicy(String absPath) throws Exception;
	void xsetRetentionPolicy(String absPath, XRetentionPolicy retentionPolicy) throws Exception;
}
