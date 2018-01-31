package xproject.xcr;

import xproject.xrmi.XRemote;

public interface XNode extends XRemote {

	void xaddMixin(String mixinName) throws Exception;
	XNode xaddNode(String relPath) throws Exception;
	XNode xaddNode(String relPath, String primaryNodeTypeName) throws Exception;
	boolean xcanAddMixin(String mixinName) throws Exception;
	void xfollowLifecycleTransition(String transition) throws Exception;
	String[] xgetAllowedLifecycleTransistions() throws Exception;
	String xgetCorrespondingNodePath(String workspaceName) throws Exception;
	String xgetIdentifier() throws Exception;
	int xgetIndex() throws Exception;
	XNode xgetNode(String relPath) throws Exception;
	boolean xhasNode(String relPath) throws Exception;
	boolean xhasNodes() throws Exception;
	boolean xhasProperties() throws Exception;
	boolean xhasProperty(String relPath) throws Exception;
	boolean xisCheckedOut() throws Exception;
	boolean xisLocked() throws Exception;
	boolean xisNodeType(String nodeTypeName) throws Exception;
	void xorderBefore(String srcChildRelPath, String destChildRelPath) throws Exception;
	void xremoveMixin(String mixinName) throws Exception;
	void xremoveSharedSet() throws Exception;
	void xsetPrimaryType(String nodeTypeName) throws Exception;
	void xupdate(String srcWorkspace) throws Exception;
}
