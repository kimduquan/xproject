package xproject.xcr;

import java.math.BigDecimal;
import java.util.Calendar;

import xproject.xcr.xnodetype.XNodeType;
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
	XNodeType[] xgetMixinNodeTypes() throws Exception;
	XNode xgetNode(String relPath) throws Exception;
	XNodeIterator xgetNodes() throws Exception;
	XNodeIterator xgetNodes(String namePattern) throws Exception;
	XNodeIterator xgetNodes(String[] nameGlobs) throws Exception;
	XNodeType xgetPrimaryNodeType() throws Exception;
	XPropertyIterator xgetProperties() throws Exception;
	XPropertyIterator xgetProperties(String namePattern) throws Exception;
	XPropertyIterator xgetProperties(String[] nameGlobs) throws Exception;
	XProperty xgetProperty(String relPath) throws Exception;
	XPropertyIterator xgetReferences() throws Exception;
	XPropertyIterator xgetReferences(String name) throws Exception;
	XNodeIterator xgetSharedSet() throws Exception;
	XPropertyIterator xgetWeakReferences() throws Exception;
	XPropertyIterator xgetWeakReferences(String name) throws Exception;
	boolean xhasNode(String relPath) throws Exception;
	boolean xhasNodes() throws Exception;
	boolean xhasProperties() throws Exception;
	boolean xhasProperty(String relPath) throws Exception;
	boolean xisCheckedOut() throws Exception;
	boolean xisLocked() throws Exception;
	boolean xisNodeType(String nodeTypeName) throws Exception;
	void xorderBefore(String srcChildRelPath, String destChildRelPath) throws Exception;
	void xremoveMixin(String mixinName) throws Exception;
	void xremoveShare() throws Exception;
	void xremoveSharedSet() throws Exception;
	void xsetPrimaryType(String nodeTypeName) throws Exception;
	XProperty xsetProperty(String name, BigDecimal value) throws Exception;
	XProperty xsetProperty(String name, XBinary value) throws Exception;
	XProperty xsetProperty(String name, boolean value) throws Exception;
	XProperty xsetProperty(String name, Calendar value) throws Exception;
	XProperty xsetProperty(String name, double value) throws Exception;
	XProperty xsetProperty(String name, long value) throws Exception;
	XProperty xsetProperty(String name, XNode value) throws Exception;
	XProperty xsetProperty(String name, String value) throws Exception;
	XProperty xsetProperty(String name, String[] values) throws Exception;
	XProperty xsetProperty(String name, String[] values, int type) throws Exception;
	XProperty xsetProperty(String name, String value, int type) throws Exception;
	XProperty xsetProperty(String name, XValue value) throws Exception;
	XProperty xsetProperty(String name, XValue[] values) throws Exception;
	XProperty xsetProperty(String name, XValue[] values, int type) throws Exception;
	XProperty xsetProperty(String name, XValue value, int type) throws Exception;
	void xupdate(String srcWorkspace) throws Exception;
}
